package com.studyboot.cocktail.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.studyboot.cocktail.domain.Cocktail;

@Repository
public class CocktailRepository {
	
	private final EntityManager em;
	
	public CocktailRepository(EntityManager em) {
		this.em = em;
	}

	public List<Cocktail> findAll() {
		List<Cocktail> result = em.createQuery("select m from Cocktail m", Cocktail.class).getResultList();
		return result;
	}

	public Cocktail add(Cocktail cocktail) {
		em.persist(cocktail);
		return cocktail;
		
	}

}
