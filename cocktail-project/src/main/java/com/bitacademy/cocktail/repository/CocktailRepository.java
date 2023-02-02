package com.bitacademy.cocktail.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.bitacademy.cocktail.domain.Cocktail;

@Repository
public class CocktailRepository {
	
	private final EntityManager em;
	
	public CocktailRepository(EntityManager em) {
		this.em = em;
	}

	public List<Cocktail> findAll() {
		List<Cocktail> result = em.createQuery("select m from cocktail m", Cocktail.class).getResultList();
		return result;
	}

	public Cocktail add(Cocktail cocktail) {
		em.persist(cocktail);
		return cocktail;
	}

}
