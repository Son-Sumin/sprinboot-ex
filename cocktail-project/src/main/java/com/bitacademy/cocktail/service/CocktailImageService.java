package com.bitacademy.cocktail.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitacademy.cocktail.domain.CocktailImage;
import com.bitacademy.cocktail.repository.CocktailImageRepository;

@Service
@Transactional
public class CocktailImageService {
	private final CocktailImageRepository cocktailImageRepository;

	public CocktailImageService(CocktailImageRepository cocktailImageRepository) {
		this.cocktailImageRepository = cocktailImageRepository;
	}
	
	public CocktailImage OneCocktailImage(Long no) {
		return cocktailImageRepository.findByCocktailNo(no);
	}
}
