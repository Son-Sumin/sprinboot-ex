package com.bitacademy.cocktail.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CocktailRecipeId implements Serializable {
	
	@Column(name = "cocktail_no")
	private Long cocktailNo;
	
	@Column(name = "ingredient_no")
	private Long ingredientNo;
}
