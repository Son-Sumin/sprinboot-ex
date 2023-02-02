package com.bitacademy.cocktail.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.bitacademy.cocktail.domain.Signature;

@Repository
public class SignatureRepository {
	
	private final EntityManager em;
	
	public SignatureRepository(EntityManager em) {
		this.em = em;
	}

	public List<Signature> findAll() {
		List<Signature> result = em.createQuery("select m from Signature m", Signature.class).getResultList();
		return result;
	}

	public Signature add(Signature signature) {
		em.persist(signature);
		return signature;
	}

}
