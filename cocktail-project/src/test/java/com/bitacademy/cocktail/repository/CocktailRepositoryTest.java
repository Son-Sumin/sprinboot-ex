package com.bitacademy.cocktail.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CocktailRepositoryTest {

	@Autowired
	private CocktailRepository cocktailRepository;

	@Autowired
	private CocktailImageRepository cocktailImageRepository;
}
