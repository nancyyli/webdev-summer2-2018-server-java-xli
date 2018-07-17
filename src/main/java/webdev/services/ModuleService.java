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

import webdev.models.Module;
import webdev.repositories.ModuleRepository;

@CrossOrigin(origins = "*", maxAge=3600)
@RestController
public class ModuleService {
  @Autowired
  ModuleRepository repository;

  @PostMapping("/api/course/{courseId}/module")
  public Module createModule(@PathVariable("courseId") int courseId, @RequestBody Module newModule) {
    repository.save(newModule);
    //TODO add new module to Course too later
    return newModule;
  }

  @DeleteMapping("/api/module/{moduleId}")
  public void deleteModule(@PathVariable("moduleId") int moduleId) {
    repository.deleteById(moduleId);
  }

  @GetMapping("/api/module")
  public List<Module> findAllModule() {
    return (List<Module>) repository.findAll();
  }

  @GetMapping("/api/module/{moduleId}")
  public Module findModuleById(@PathVariable("moduleId") int moduleId) {
    Optional<Module> data = repository.findById(moduleId);
    if(data.isPresent()) {
      return data.get();
    }
    return null;
  }

  @GetMapping("/api/course/{courseId}/module")
  public List<Module> findAllModulesForCourse(@PathVariable("courseId") int courseId) {
      //TODO: implement a repository method
      return (List<Module>)repository.findAll();
  }

  @PutMapping("/api/module/{moduleId}")
  public Module updateModule(@PathVariable("moduleId") int moduleId, @RequestBody Module newModule) {
    Optional<Module> data = repository.findById(moduleId);
    if(data.isPresent()) {
      Module module = data.get();
      module.setTitle(newModule.getTitle());
      module.setCourse(newModule.getCourse());
      repository.save(module);
      return module;
    }
    return null;
  }


}
