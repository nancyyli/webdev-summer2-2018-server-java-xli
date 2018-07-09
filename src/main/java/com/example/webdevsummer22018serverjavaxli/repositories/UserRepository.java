package com.example.webdevsummer22018serverjavaxli.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.example.webdevsummer22018serverjavaxli.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

  @Query("SELECT u FROM User u WHERE u.username=:username")
  Optional<User> findUserByusername(@Param("username") String username);

}