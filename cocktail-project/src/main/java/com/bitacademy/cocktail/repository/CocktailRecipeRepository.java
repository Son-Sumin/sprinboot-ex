package com.bitacademy.cocktail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.bitacademy.cocktail.domain.CocktailRecipe;

@EnableJpaRepositories
public interface CocktailRecipeRepository extends JpaRepository<CocktailRecipe, Long> {

	@Query(value = "select b.name, c.*, a.amount, a.unit "
			+ "from cocktailRecipe a, cocktail b, ingredient c "
			+ "where b.no = :cocktailNo "
			+ "and a.ingredient_no = c.no",
			nativeQuery = true)
	//@EntityGraph(attributePaths = {"cocktail"})
	List<CocktailRecipe> findByCocktail(@Param("cocktailNo") Long cocktailNo);
	
//	@Query("select cr.ingredient_no from CocktailRecipe as cr "
//			+ "where cr.ingredient_no = :ingredientNo")
	@EntityGraph(attributePaths = {"ingredient"})
	List<CocktailRecipe> findByIngredientNo(@Param("ingredientNo") Long ingredientNo);
}
