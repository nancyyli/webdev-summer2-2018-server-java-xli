package com.example.webdevsummer22018serverjavaxli.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.webdevsummer22018serverjavaxli.models.User;
import com.example.webdevsummer22018serverjavaxli.repositories.UserRepository;

import javax.servlet.http.HttpSession;

@RestController
public class UserService {
    @Autowired
    UserRepository repository;

    @DeleteMapping("/api/user/{userId}")
    public void deleteUser(@PathVariable("userId") int id) {
      repository.deleteById(id);
    }

    @PostMapping("/api/user")
    public User createUser(@RequestBody User user) {
      return repository.save(user);
    }

    @PostMapping("/api/login")
    public User login(@RequestBody User user, HttpSession session) {
      Optional<User> currentUser = repository.findUserByUserNameAndPassword(user.getUsername(), user.getPassword());
      if (currentUser.isPresent()) {
        session.setAttribute("currentUser", currentUser);
        return (User) currentUser.get();
      }
      return null;
    }

    @GetMapping("/checkLogin")
    public User checkLogin(HttpSession session) {
      return (User) session.getAttribute("currentUser");
    }
    @GetMapping("/api/user")
    public List<User> findAllUsers() {
      return (List<User>) repository.findAll();
    }

    @PutMapping("/api/user/{userId}")
    public User updateUser(@PathVariable("userId") int userId, @RequestBody User newUser) {
      Optional<User> data = repository.findById(userId);
      if(data.isPresent()) {
        User user = data.get();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        user.setRole(newUser.getRole());
        repository.save(user);
        return user;
      }
      return null;
    }

    @GetMapping("/api/user/{userId}")
    public User findUserById(@PathVariable("userId") int userId) {
      Optional<User> data = repository.findById(userId);
      if(data.isPresent()) {
        return data.get();
      }
      return null;
    }

    @PostMapping("/api/register")
    public User register(@RequestBody User user, HttpSession session) {
      User currentUser = findUserByUsername(user.getUsername());
      if (currentUser == null) {
        currentUser = createUser(user);
      }
      session.setAttribute("currentUser", currentUser);
      return currentUser;
    }

    @GetMapping("/api/user/username/{userName}")
    public User findUserByUsername(@PathVariable("userName") String userName) {
      Optional<User> data = repository.findUserByUsername(userName);
      if(data.isPresent()) {
        return data.get();
      }
      return null;
    }

  @PutMapping("/api/profile/update")
  public User updateProfile(@RequestBody User user, HttpSession session) {
    Optional<User> currentUser = (Optional<User>) session.getAttribute("currentUser");
    if (currentUser.isPresent()) {
      User currentUserData = currentUser.get();
      if (currentUserData.getUsername().equals(user.getUsername())) {
        int userId = currentUserData.getId();
        Optional<User> data = repository.findById(userId);
        if(data.isPresent()) {
          User updateUser = data.get();
          updateUser.setFirstName(user.getFirstName());
          updateUser.setLastName(user.getLastName());
          updateUser.setRole(user.getRole());
          updateUser.setPhone(user.getPhone());
          updateUser.setEmail(user.getEmail());
          updateUser.setDateOfBirth(user.getDateOfBirth());
          repository.save(updateUser);
          return updateUser;
        }
        return null;
      }
    }
    return null;
  }

  @GetMapping("/api/profile")
  public User profile(HttpSession session) {
      Optional<User> user = (Optional<User>) session.getAttribute("currentUser");
      if (user.isPresent()) {
        return repository.findById(user.get().getId()).get();
      }
      return null;
  }

  @PostMapping("/api/logout")
  public User logout(HttpSession session) {
      return null;
  }




}