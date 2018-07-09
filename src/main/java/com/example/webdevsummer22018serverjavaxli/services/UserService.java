package com.example.webdevsummer22018serverjavaxli.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsummer22018serverjavaxli.models.User;
import com.example.webdevsummer22018serverjavaxli.repositories.UserRepository;

import javax.servlet.http.HttpSession;

@RestController
public class UserService {

  @Autowired
  UserRepository userRepository;

  @PostMapping("/api/user")
  public User createUser(@RequestBody User user) {
    return userRepository.save(user);
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


  @GetMapping("/api/user")
  public List<User> findAllUsers() {
    return (List<User>) userRepository.findAll();
  }

  @GetMapping("/api/user/{userName}")
  public User findUserByUsername(@PathVariable("userName") String userName) {
    Optional<User> data = userRepository.findUserByusername(userName);
    if(data.isPresent()) {
      return data.get();
    }
    return null;
  }

}