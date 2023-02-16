package com.bitacademy.cocktail.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="cocktailRecipe")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CocktailRecipe{
	
	@EmbeddedId
	private CocktailRecipeId crId;

	private Float amount;
	private String unit;
	
//	@ManyToOne
//	@JoinColumn(name = "cocktail_no")
//	@ToString.Exclude
//	@JsonIgnore
//	private Cocktail cocktail;
//	
//	@ManyToOne
//	@JoinColumn(name = "ingredient_no")
//	@ToString.Exclude
//	@JsonIgnore
//	private Ingredient ingredient;

}
