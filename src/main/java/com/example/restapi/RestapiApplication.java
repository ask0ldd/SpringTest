package com.example.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.restapi.model.Message;
import com.example.restapi.service.BusinessService;

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

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Message message = bs.getMessage();
		System.out.println(message);
	}
}
