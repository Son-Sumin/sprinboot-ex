package com.bitacademy.cocktail.service;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bitacademy.cocktail.domain.Signature;

@SpringBootTest
public class SignatureServiceTest {

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
	}
	
	@Test
	void testModify() {
		
	}
	
	@Test
	void testDelete() {
		
	}
}
