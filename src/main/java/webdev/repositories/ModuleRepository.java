package webdev.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import webdev.models.Module;

import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ModuleRepository extends CrudRepository<Module, Integer> {
    @Query("SELECT m FROM Module m WHERE m.course.id=:courseId")
    List<Module> findModulesByCourse(@Param("courseId") Integer courseId);
}
