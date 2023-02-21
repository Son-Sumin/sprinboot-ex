package com.bitacademy.cocktail.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="ingredient")
@ToString(exclude = {"cocktailRecipes"})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "no")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;

	private String name;

	@Column(name = "eng_name")
	private String engName;
	
	private String type;
	
	private float degree;
	
	private String contents;
	
	private String image;

	@JsonIgnoreProperties({"cocktail"})
	@OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
	@Builder.Default
	private List<CocktailRecipe> cocktailRecipes = new ArrayList<>();
	
//	@ToString.Exclude
//	@JsonIgnoreProperties({"signatureRecipes"})
//	@OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
//	private List<SignatureRecipe> signatureRecipes = new ArrayList<>();
	
//	@Builder
//	public Ingredient(String name, String engName, String type,
//						float degree, String image, CocktailRecipe cocktailRecipe) {
//      this.name = name;
//      this.engName = engName;
//      this.type = type;
//      this.name = name;
//      this.degree = degree;
//	}

}
