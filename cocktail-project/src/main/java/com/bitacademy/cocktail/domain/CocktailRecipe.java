package com.bitacademy.cocktail.domain;

import javax.persistence.Entity;
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
public class CocktailRecipe {
	
	private Float amount;
	private String unit;
	
	@ManyToOne
	@JoinColumn(name = "cocktail_no")
	@ToString.Exclude
	@JsonIgnore
	private Cocktail cocktail;
	
	@ManyToOne
	@JoinColumn(name = "ingredient_no")
	@ToString.Exclude
	@JsonIgnore
	private Ingredient ingredient;

}
