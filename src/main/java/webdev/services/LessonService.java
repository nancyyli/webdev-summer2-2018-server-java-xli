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

import webdev.models.Lesson;
import webdev.models.Module;
import webdev.repositories.LessonRepository;
import webdev.repositories.ModuleRepository;

@CrossOrigin(origins = "*", maxAge=3600)
@RestController
public class LessonService {
  @Autowired
  LessonRepository repository;
  @Autowired
  ModuleRepository moduleRepository;

  @PostMapping("/api/course/{courseId}/module/{moduleId}/lesson")
  public Lesson createLesson(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId, @RequestBody Lesson lesson) {
    Lesson newLesson = new Lesson();
    Optional<Module> module = moduleRepository.findById(moduleId);
    if (module.isPresent()) {
      newLesson.setTitle(lesson.getTitle());
      newLesson.setModule(lesson.getModule());
      repository.save(newLesson);
      //TODO add new module to Course too later
      return newLesson;
    }
    return null;
  }

  @DeleteMapping("/api/lesson/{lessonId}")
  public void deleteLesson(@PathVariable("lessonId") int lessonId) {
    repository.deleteById(lessonId);
  }

  @GetMapping("/api/lesson")
  public List<Lesson> findAllLessons() {
    return (List<Lesson>) repository.findAll();
  }

  @GetMapping("/api/lesson/{lessonId}")
  public Lesson findLessonById(@PathVariable("lessonId") int lessonId) {
    Optional<Lesson> data = repository.findById(lessonId);
    if(data.isPresent()) {
      return data.get();
    }
    return null;
  }

  @GetMapping("/api/course/{courseId}/module/{moduleId}/lesson")
  public List<Lesson> findAllLessonsForModule(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId) {
    //TODO: implement a repository method
    return repository.findLessonsByModule(moduleId);
  }

  @PutMapping("/api/lesson/{lessonId}")
  public Lesson updateLesson(@PathVariable("lessonId") int lessonId, @RequestBody Lesson newLesson) {
    Optional<Lesson> data = repository.findById(lessonId);
    if(data.isPresent()) {
      Lesson lesson = data.get();
      lesson.setTitle(newLesson.getTitle());
      lesson.setModule(newLesson.getModule());
      repository.save(lesson);
      return lesson;
    }
    return null;
  }


}
