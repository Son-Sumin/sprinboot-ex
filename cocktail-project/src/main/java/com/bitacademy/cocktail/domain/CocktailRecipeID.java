package com.bitacademy.cocktail.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CocktailRecipeID implements Serializable {
	
	private Long CocktailNo;
	private Long IngredientNo;
}
