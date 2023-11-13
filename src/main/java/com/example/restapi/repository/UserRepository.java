package com.example.restapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // custom query
    Optional<User> findByEmail(String email);
}