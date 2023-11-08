package com.example.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.User;
import com.example.restapi.service.UserService;

/*
 * @RestController atteint 2 objectifs :
 * Comme @Component, elle permet d’indiquer à Spring que cette classe est un bean.
 * Elle indique à Spring d’insérer le retour de la méthode au format JSON dans le corps de la réponse HTTP. 
 * Grâce à ce deuxième point, les applications qui vont communiquer avec votre API accéderont au résultat de leur requête en parsant la réponse HTTP.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Read - Get all employees
     * 
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /*
     * public ResponseEntity<String> handlePostRequest(@RequestBody String
     * requestBody) {
     * // Handle the POST request here
     * return ResponseEntity.ok("POST request handled successfully");
     * }
     */

}
