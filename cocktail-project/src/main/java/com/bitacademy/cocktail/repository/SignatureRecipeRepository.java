package com.bitacademy.cocktail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitacademy.cocktail.domain.SignatureRecipe;

public interface SignatureRecipeRepository extends JpaRepository<SignatureRecipe, Long>{

}
