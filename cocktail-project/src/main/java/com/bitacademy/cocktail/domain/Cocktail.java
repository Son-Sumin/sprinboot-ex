package com.bitacademy.cocktail.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="cocktail")
@Data
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
	
}
