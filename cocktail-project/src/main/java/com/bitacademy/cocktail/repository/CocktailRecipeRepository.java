package com.bitacademy.cocktail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitacademy.cocktail.domain.CocktailRecipe;
import com.bitacademy.cocktail.domain.CocktailRecipeID;

@Repository
public interface CocktailRecipeRepository extends JpaRepository<CocktailRecipe, CocktailRecipeID> {

}
