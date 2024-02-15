package com.example.DatabaseWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCaching
public class DatabaseWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseWebAppApplication.class, args);
	}

	@GetMapping("/")
	public String apiRoot() {
		return "Book API up and running!";
	}
}
