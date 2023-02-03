package com.bitacademy.cocktail.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitacademy.cocktail.domain.Cocktail;
import com.bitacademy.cocktail.repository.CocktailRepository;


@Service
@Transactional
public class CocktailService {
	
	private final CocktailRepository cocktailRepository;
	
	public CocktailService(CocktailRepository cocktailRepository) {
		this.cocktailRepository = cocktailRepository;
	}

	public List<Cocktail> listCocktail() {
		return cocktailRepository.findAll();
	}

	public void add(Cocktail cocktail) {
		cocktailRepository.save(cocktail);
	}

}
