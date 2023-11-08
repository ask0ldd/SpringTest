package com.example.restapi.service;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.repository.UserRepository;
import com.example.restapi.model.User;

import lombok.Data;

@Data
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }

    public User saveEmployee(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

}
