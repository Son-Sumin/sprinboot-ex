package com.bitacademy.cocktail.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bitacademy.cocktail.domain.Ingredient;
import com.bitacademy.cocktail.repository.IngredientRepository;

@Service
@Transactional
public class IngredientService {
	
	private final IngredientRepository ingredientRepository;
	
	public IngredientService(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}

	/* 재료 목록 불러오기 */
	public List<Ingredient> listIngredient() {
		return ingredientRepository.findAll();
	}

	/* 재료 게시글 불러오기 */
	public Ingredient findIngreView(Long no) {
		return ingredientRepository.findByNo(no);
	}

}
