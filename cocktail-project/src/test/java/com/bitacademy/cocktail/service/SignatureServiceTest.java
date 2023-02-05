package com.bitacademy.cocktail.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bitacademy.cocktail.domain.Signature;

@SpringBootTest
public class SignatureServiceTest {

	@Autowired
	SignatureService signatureService;
	
	@Test
	void testAdd() {
		Signature signature = Signature.builder()
				.nickname("맹구")
				.cocktailName("하와이안블루")
				.regDate(LocalDateTime.now())
				.cocktailContents("맹구의 하와이안 블루")
				.recipeContents("빙글빙글")
				.type("alcohol")
				.build();
		
		signatureService.add(signature);
	}
	
	@Test
	void testModify() {
		/* 전체수정도 하지만 부분수정할 경우 고려하여 아래 방법 실시
		Signature signature = new Signature();
		
		signature.setNo(1);
		signature.setNickname("수정");
		signature.setRegDate(LocalDateTime.now());
		signature.setCocktailName("수정");
		signature.setCocktailContents("수정");
		signature.setRecipeContents("수정");
		signature.setType("alcohol");
		*/
		
		Signature signature = signatureService.findSigView(1L);
		signature.setCocktailContents("이것만 수정");
		
		signatureService.modify(signature);
	}
	
	@Test
	@Transactional  // Rollback 처리
	void testDelete() {
		signatureService.delete(1L);
	}
}
