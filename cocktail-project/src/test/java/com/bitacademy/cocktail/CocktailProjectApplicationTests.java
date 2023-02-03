package com.bitacademy.cocktail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bitacademy.cocktail.domain.Signature;
import com.bitacademy.cocktail.repository.SignatureRepository;

@SpringBootTest
class CocktailProjectApplicationTests {

	@Autowired
	SignatureRepository sigRepo;
	
	@Test
	public void testSelectAll() {
		List<Signature> list = sigRepo.findAll();
		
		for(Signature signature : list) {
			System.out.println(signature.getNo());
			System.out.println(signature.getNickname());
			System.out.println(signature.getCocktailName());
			System.out.println(signature.getRegDate());
			System.out.println(signature.getCocktailContents());
			System.out.println(signature.getRecipeContents());
			System.out.println(signature.getType());
		}
	}
	
	@Test
	public void testSelectOne() {
		Signature signature = sigRepo.findByNo(11L);

		System.out.println(signature.getNo());
		System.out.println(signature.getNickname());
		System.out.println(signature.getCocktailName());
		System.out.println(signature.getRegDate());
		System.out.println(signature.getCocktailContents());
		System.out.println(signature.getRecipeContents());
		System.out.println(signature.getType());
		
	}
}
