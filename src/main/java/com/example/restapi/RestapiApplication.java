package com.example.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.restapi.model.Message;
import com.example.restapi.model.User;
import com.example.restapi.service.BusinessService;
import com.example.restapi.service.UserService;

@SpringBootApplication
/*
 * 
 * Spring Boot fournit une interface nommée “CommandLineRunner”. En implémentant
 * cette interface,
 * la classe sera obligée de déclarer la méthode “public void run(String...
 * args) throws Exception“.
 * À partir de là, si la classe est un bean (c’est-à-dire chargée dans le
 * contexte Spring),
 * Spring Boot exécutera la méthode run à l’exécution du programme.
 * 
 */
public class RestapiApplication /* */ implements CommandLineRunner {

	@Autowired // instanciates the service since declared as a component
	private BusinessService bs;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Message message = bs.getMessage();
		System.out.println(message);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		userService.saveUser(new User("Laurent", "GINA", "laurentgina@mail.com",
				passwordEncoder.encode("laurent")));
		userService.saveUser(new User("Sophie", "FONCEK", "sophiefoncek@mail.com",
				passwordEncoder.encode("sophie")));
		userService.saveUser(new User("Agathe", "FEELING", "agathefeeling@mail.com",
				passwordEncoder.encode("agathe")));

	}
}
