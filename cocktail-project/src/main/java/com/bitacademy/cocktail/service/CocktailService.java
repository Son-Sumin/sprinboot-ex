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
	
	public void add(Cocktail cocktail) {
		cocktailRepository.save(cocktail);
	}
	
	public List<Cocktail> listCocktail() {
		return cocktailRepository.findAll();
	}

	public Cocktail findSigView(Long no) {
		return cocktailRepository.findByNo(no);
	}

}