package com.example.rest.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class RestApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("The console is working.");
	}
}
