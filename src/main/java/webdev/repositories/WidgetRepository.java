package webdev.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webdev.models.Lesson;
import webdev.models.Widget;

import org.springframework.data.repository.query.Param;

import java.util.List;


public interface WidgetRepository extends CrudRepository<Widget, Integer> {
  @Query("SELECT w FROM Widget w WHERE w.lesson.id =:lessonId")
  List<Widget> findWidgetsByLesson(@Param("lessonId") Integer lessonId);

}
