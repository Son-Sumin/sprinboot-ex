package com.bitacademy.cocktail.repository;

import java.util.List;

import javax.persistence.Embeddable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitacademy.cocktail.domain.CocktailRecipe;
import com.bitacademy.cocktail.domain.CocktailRecipeID;

@Embeddable
public interface CocktailRecipeRepository extends JpaRepository<CocktailRecipe, CocktailRecipeID> {

	List<CocktailRecipe> findByCocktailNo(Long cocktailNo);
	
	List<CocktailRecipe> findByIngredientNo(Long ingredientNo);
}
