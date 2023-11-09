package com.example.restapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") final Long id) {
        System.out.println(id);
        Optional<User> user = userService.getUser(id);
        System.out.println(user);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
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