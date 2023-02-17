package com.bitacademy.cocktail.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bitacademy.cocktail.domain.Cocktail;
import com.bitacademy.cocktail.domain.CocktailRecipe;
import com.bitacademy.cocktail.repository.CocktailRecipeRepository;
import com.bitacademy.cocktail.repository.CocktailRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CocktailRecipeService {

	/* CocktailRecipeRepository 생성자 주입 */
	private final CocktailRepository cocktailRepository;
	private final CocktailRecipeRepository cocktailRecipeRepository;
	
	/* 칵테일 레시피 리스트 */
	public List<CocktailRecipe> listCocktailRecipe() {
		return cocktailRecipeRepository.findAll();
	}
	
	/* cocktailNo에 따른 칵테일 레시피 */
	public List<CocktailRecipe> findByCocktailNo(Long cocktailNo, CocktailRecipe cocktailRecipe) {
		Cocktail cocktail = cocktailRepository.findByNo(cocktailNo);
		cocktailRecipe.setCocktail(cocktail);
		return cocktailRecipeRepository.findByCocktailNo(cocktailNo);
	}
	
	/* ingredientNo에 따른 칵테일 레시피 */
	public List<CocktailRecipe> findByIngredientNo(Long ingredientNo) {
		return cocktailRecipeRepository.findByIngredientNo(ingredientNo);
	}
}
