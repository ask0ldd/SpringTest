package com.example.restapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.User;
import com.example.restapi.service.UserService;
import com.example.restapi.service.ValidationService;

/*
 * @RestController atteint 2 objectifs :
 * Comme @Component, elle permet d’indiquer à Spring que cette classe est un bean.
 * Elle indique à Spring d’insérer le retour de la méthode au format JSON dans le corps de la réponse HTTP. 
 * Grâce à ce deuxième point, les applications qui vont communiquer avec votre API accéderont au résultat de leur requête en parsant la réponse HTTP.
 */
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ValidationService validationService;

    /**
     * Read - Get all users
     * 
     * @return - An Iterable object of Users
     */
    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<?> getUserByEmail(@RequestBody String email) {
        Optional<User> userOptional = userService.getUserByEmail(email);
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Can't find the requested User.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") final Long id) {
        Optional<User> userOptional = userService.getUser(id);
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Can't find the requested User.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") final Long id, @RequestBody User user) {
        Optional<User> userOptional = userService.getUser(id);
        if (userOptional.isPresent()) {
            User currentUser = userOptional.get();

            String firstName = user.getFirstname();
            if (firstName != null && validationService.isName(firstName)) {
                currentUser.setFirstname(firstName);
            }

            String lastName = user.getLastname();
            if (lastName != null && validationService.isName(lastName)) {
                currentUser.setLastname(lastName);
            }

            String mail = user.getEmail();
            if (mail != null && validationService.isEmail(mail)) {
                currentUser.setEmail(mail);
            }

            String password = user.getPassword();
            if (password != null) {
                currentUser.setPassword(password);
            }
            userService.saveUser(currentUser);

            return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Can't find the requested User.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") final Long id) {
        userService.deleteUser(id);
    }

}

/*
 * package com.openclassrooms.api.controller;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.DeleteMapping;
 * import org.springframework.web.bind.annotation.GetMapping;
 * import org.springframework.web.bind.annotation.PathVariable;
 * import org.springframework.web.bind.annotation.PostMapping;
 * import org.springframework.web.bind.annotation.PutMapping;
 * import org.springframework.web.bind.annotation.RequestBody;
 * import org.springframework.web.bind.annotation.RestController;
 * 
 * import com.openclassrooms.api.model.Employee;
 * import com.openclassrooms.api.service.EmployeeService;
 * 
 * @RestController
 * public class EmployeeController {
 * 
 * @Autowired
 * private EmployeeService employeeService;
 * 
 * @PostMapping("/employee")
 * public Employee createEmployee(@RequestBody Employee employee) {
 * return employeeService.saveEmployee(employee);
 * }
 * 
 * 
 * @GetMapping("/employee/{id}")
 * public Employee getEmployee(@PathVariable("id") final Long id) {
 * Optional<Employee> employee = employeeService.getEmployee(id);
 * if(employee.isPresent()) {
 * return employee.get();
 * } else {
 * return null;
 * }
 * }
 * 
 * @GetMapping("/employees")
 * public Iterable<Employee> getEmployees() {
 * return employeeService.getEmployees();
 * }
 * 
 * @PutMapping("/employee/{id}")
 * public Employee updateEmployee(@PathVariable("id") final Long
 * id, @RequestBody Employee employee) {
 * Optional<Employee> e = employeeService.getEmployee(id);
 * if(e.isPresent()) {
 * Employee currentEmployee = e.get();
 * 
 * String firstName = employee.getFirstName();
 * if(firstName != null) {
 * currentEmployee.setFirstName(firstName);
 * }
 * String lastName = employee.getLastName();
 * if(lastName != null) {
 * currentEmployee.setLastName(lastName);;
 * }
 * String mail = employee.getMail();
 * if(mail != null) {
 * currentEmployee.setMail(mail);
 * }
 * String password = employee.getPassword();
 * if(password != null) {
 * currentEmployee.setPassword(password);;
 * }
 * employeeService.saveEmployee(currentEmployee);
 * return currentEmployee;
 * } else {
 * return null;
 * }
 * }
 * 
 * @DeleteMapping("/employee/{id}")
 * public void deleteEmployee(@PathVariable("id") final Long id) {
 * employeeService.deleteEmployee(id);
 * }
 * 
 * 
 * }
 * 
 * 
 */

/*
 * public ResponseEntity<String> handlePostRequest(@RequestBody String
 * requestBody) {
 * // Handle the POST request here
 * return ResponseEntity.ok("POST request handled successfully");
 * }
 */