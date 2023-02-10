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
//public class CocktailService3 {
//
//	private final CocktailRepository cocktailRepository;
//
//	public CocktailService3(CocktailRepository cocktailRepository) {
//		this.cocktailRepository = cocktailRepository;
//	}
//	
//	/* 칵테일 추가하기 */
//	@ModelAttribute
//	public Cocktail add(Cocktail cocktail) {
//		return cocktailRepository.save(cocktail);
//	}
//
//	/* 칵테일 목록 불러오기 */
//	public List<Cocktail> listCocktail() {
//		return cocktailRepository.findAll();
//	}
//
//	/* 칵테일 게시글 불러오기 */
//	public Cocktail findSigView(Long no) {
//		return cocktailRepository.findByNo(no);
//	}
//
//}
