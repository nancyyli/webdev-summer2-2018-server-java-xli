package webdev.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webdev.models.Lesson;
import webdev.models.Module;

import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface LessonRepository extends CrudRepository<Lesson, Integer> {
    @Query("SELECT l FROM Lesson l WHERE l.module.id=:moduleId")
    List<Lesson> findLessonsByModule(@Param("moduleId") Integer moduleId);
}
