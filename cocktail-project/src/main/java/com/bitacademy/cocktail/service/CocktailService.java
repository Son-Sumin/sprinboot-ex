package com.bitacademy.cocktail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitacademy.cocktail.repository.CocktailRepository;
import com.bitacademy.cocktail.domain.Cocktail;


@Service
@Transactional
public class CocktailService {
	
	private final CocktailRepository cocktailRepository;
	
	@Autowired
	public CocktailService(CocktailRepository cocktailRepository) {
		this.cocktailRepository = cocktailRepository;
	}

	public List<Cocktail> listCocktail() {
		return cocktailRepository.findAll();
	}

	public void add(Cocktail cocktail) {
		cocktailRepository.add(cocktail);
	}

}
