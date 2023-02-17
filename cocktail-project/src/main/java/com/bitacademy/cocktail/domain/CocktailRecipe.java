package com.bitacademy.cocktail.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="cocktailRecipe")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@IdClass(CocktailRecipeId.class)
public class CocktailRecipe{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;

	@ManyToOne  @JsonIgnore
	@JoinColumn(name = "cocktail_no")
	private Cocktail cocktail;
	
	@ManyToOne  @JsonIgnore
	@JoinColumn(name = "ingredient_no")
	private Ingredient ingredient;
	
	private Long amount;
	private String unit;
	
	@Builder
	public CocktailRecipe(Cocktail cocktail, Ingredient ingredient, Long amount, String unit) {
      this.amount = amount;
      this.unit = unit;
      this.cocktail = cocktail;
      this.ingredient = ingredient;
      cocktail.getCocktailRecipes().add(this);
      ingredient.getCocktailRecipe().add(this);
	}
	
//	@Id
//	private CocktailRecipeId crId;
}