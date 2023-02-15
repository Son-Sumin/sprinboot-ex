//// 사용 X
//
//
//package com.bitacademy.cocktail.service;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.bitacademy.cocktail.domain.CocktailImage;
//import com.bitacademy.cocktail.repository.CocktailImageRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class CocktailImageService {
//	
//	private final CocktailImageRepository cocktailImageRepository;
//	
//	public CocktailImage OneCocktailImage(Long no) {
//		return cocktailImageRepository.findByCocktailNo(no);
//	}
//
//	public List<CocktailImage> listCocktailImage() {
//		return cocktailImageRepository.findAll();
//	}
//	
//	public List<CocktailImage> listCocktailImageUrl(Long no) {
//		return cocktailImageRepository.findUrlByCocktailNo(no);
//	}
//}
