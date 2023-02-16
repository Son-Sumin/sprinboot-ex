package com.bitacademy.cocktail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.bitacademy.cocktail.domain.CocktailRecipe;
import com.bitacademy.cocktail.domain.CocktailRecipeId;

public interface CocktailRecipeRepository extends JpaRepository<CocktailRecipe, CocktailRecipeId> {

	@EntityGraph(attributePaths = {"cocktail"})
	List<CocktailRecipe> findByCocktailNo(@Param("cocktailNo") Long cocktailNo);
	
	@EntityGraph(attributePaths = {"ingredient"})
	List<CocktailRecipe> findByIngredientNo(@Param("ingredientNo") Long ingredientNo);
}
