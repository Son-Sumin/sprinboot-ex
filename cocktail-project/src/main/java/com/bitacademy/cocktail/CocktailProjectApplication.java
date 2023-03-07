package com.bitacademy.cocktail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EntityScan(basePackages = "com.bitacademy.cocktail.domain")
public class CocktailProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CocktailProjectApplication.class, args);
	}
}
