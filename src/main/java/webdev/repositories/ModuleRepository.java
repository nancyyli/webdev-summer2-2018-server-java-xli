package webdev.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import webdev.models.Course;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ModuleRepository extends CrudRepository<Course, Integer> {

}
