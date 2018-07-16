package webdev.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import webdev.models.Course;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface CourseRepository extends CrudRepository<Course, Integer> {
  @Query("SELECT u FROM Course u WHERE u.ownedBy=:ownedBy")
  Optional<Course> findCoursesByUsername(@Param("ownedBy") String ownedBy);

}
