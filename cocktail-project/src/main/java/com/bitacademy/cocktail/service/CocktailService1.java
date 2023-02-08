//package com.bitacademy.cocktail.service;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import com.bitacademy.cocktail.domain.Cocktail;
//import com.bitacademy.cocktail.repository.CocktailRepository;
//
//
//@Service
//@Transactional
//public class CocktailService1 {
//	
//	private final CocktailRepository cocktailRepository;
//	
//	public CocktailService1(CocktailRepository cocktailRepository) {
//		this.cocktailRepository = cocktailRepository;
//	}
//	
//	@ModelAttribute 
//	public Cocktail add(Cocktail cocktail) {
//		return cocktailRepository.save(cocktail);
//	}
//	
//	public List<Cocktail> listCocktail() {
//		return cocktailRepository.findAll();
//	}
//
//	public Cocktail findSigView(Long no) {
//		return cocktailRepository.findByNo(no);
//	}
//
//}
