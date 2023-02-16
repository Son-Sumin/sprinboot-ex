package com.bitacademy.cocktail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitacademy.cocktail.domain.CocktailRecipe;
import com.bitacademy.cocktail.domain.CocktailRecipeId;

public interface CocktailRecipeRepository extends JpaRepository<CocktailRecipe, CocktailRecipeId> {

	List<CocktailRecipe> findByCocktailNo(Long cocktailNo);
	
	List<CocktailRecipe> findByIngredientNo(Long ingredientNo);
}
