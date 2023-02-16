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
@IdClass(CocktailRecipeId.class)
public class CocktailRecipe{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;

	@ManyToOne
	@JoinColumn(name = "cocktail_no")
	private Long cocktailNo;
	
	@ManyToOne
	@JoinColumn(name = "ingredient_no")
	private Long ingredientNo;
	
	private Long amount;
	private String unit;
	
//	@Id
//	private CocktailRecipeId crId;
}
