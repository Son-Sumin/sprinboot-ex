package com.bitacademy.cocktail.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bitacademy.cocktail.domain.CocktailRecipe;
import com.bitacademy.cocktail.repository.CocktailRecipeRepository;

@Service
@Transactional
public class CocktailRecipeService {

	private final CocktailRecipeRepository cocktailRecipeRepository;
	public CocktailRecipeService(CocktailRecipeRepository cocktailRecipeRepository) {
		this.cocktailRecipeRepository = cocktailRecipeRepository;
	}
	
	/* 칵테일 레시피 리스트 */
	public List<CocktailRecipe> listCocktailRecipe() {
		return cocktailRecipeRepository.findAll();
	}
	
	/* cocktailNo에 따른 칵테일 레시피 */
	public List<CocktailRecipe> recipeByCocktailNo(Long cocktailNo) {
		return cocktailRecipeRepository.findByCocktailNo(cocktailNo);
	}
	
	/* ingredientNo에 따른 칵테일 레시피 */
	public List<CocktailRecipe> recipeByIngredientNo(Long ingredientNo) {
		return cocktailRecipeRepository.findByIngredientNo(ingredientNo);
	}
}
