package com.bitacademy.cocktail.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="cocktailImage")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CocktailImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	private String url;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cocktail_no")
	private Cocktail cocktail;
	
}
