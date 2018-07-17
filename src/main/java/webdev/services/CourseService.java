package webdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import webdev.models.Course;
import webdev.repositories.CourseRepository;

@CrossOrigin(origins = "*", maxAge=3600)
@RestController
public class CourseService {
  @Autowired
  CourseRepository repository;


  @PostMapping("/api/course")
  public Course createCourse(@RequestBody Course course) {
    Course newCourse = new Course();
    newCourse.setTitle(course.getTitle());
    newCourse.setOwnedBy(course.getOwnedBy());
    newCourse.setCreated();
    newCourse.setModified();
    repository.save(newCourse);
    return newCourse;
  }

  @DeleteMapping("/api/course/{courseId}")
  public void deleteCourse(@PathVariable("courseId") int id) {
    repository.deleteById(id);
  }

  @GetMapping("/api/course")
  public List<Course> findAllCourses() {
      return (List<Course>) repository.findAll();
  }

  @GetMapping("/api/course/{courseId}")
  public Course findCourseById(@PathVariable("courseId") int courseId) {
    Optional<Course> data = repository.findById(courseId);
    if(data.isPresent()) {
      return data.get();
    }
    return null;
  }

  @PutMapping("/api/course/{courseId}")
  public Course updateCourse(@PathVariable("courseId") int courseId, @RequestBody Course newCourse) {
    Optional<Course> data = repository.findById(courseId);
    if(data.isPresent()) {
      Course course = data.get();
      course.setTitle(newCourse.getTitle());
      course.setModified();
      repository.save(course);
      return course;
    }
    return null;
  }


}
