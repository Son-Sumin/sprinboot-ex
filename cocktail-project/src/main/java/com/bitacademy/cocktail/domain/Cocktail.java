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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="cocktail")
@ToString(exclude = "cocktailImages")
@Getter @Setter 
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cocktail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;

	private String type;

	private String name;

	@Column(name = "eng_name")
	private String engName;

	@Column(name = "cocktail_contents")
	private String cocktailContents;

	@Column(name = "recipe_contents")
	private String recipeContents;

	@JsonIgnore
	@OneToMany(mappedBy = "cocktail", cascade = CascadeType.ALL, orphanRemoval = true)
	//private CocktailImage cocktailImages;
	
	private List<CocktailImage> cocktailImages = new ArrayList<>();

	public void addCocktailImage(CocktailImage cocktailImage){
		this.cocktailImages.add(cocktailImage);
		cocktailImage.setCocktail(this);
    }
}
