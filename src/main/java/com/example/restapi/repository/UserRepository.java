package com.example.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}