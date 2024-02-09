package com.example.DatabaseWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DatabaseWebAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(DatabaseWebAppApplication.class, args);
	}

	@GetMapping("/")
	public String apiRoot() {
		return "Book API up and running!";
	}
}
