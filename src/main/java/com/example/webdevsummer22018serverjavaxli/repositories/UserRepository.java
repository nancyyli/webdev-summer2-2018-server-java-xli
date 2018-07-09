package com.example.webdevsummer22018serverjavaxli.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.webdevsummer22018serverjavaxli.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
  
}
