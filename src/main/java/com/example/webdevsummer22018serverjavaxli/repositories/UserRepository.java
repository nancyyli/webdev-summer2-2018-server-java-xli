package com.example.webdevsummer22018serverjavaxli.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.webdevsummer22018serverjavaxli.models.User;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.username=:username AND u.password=:password")
    Iterable<User> findUserByCredentials(@Param("username") String username, @Param("password") String password);
}
