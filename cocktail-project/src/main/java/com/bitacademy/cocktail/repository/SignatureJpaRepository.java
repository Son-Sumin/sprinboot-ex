package com.bitacademy.cocktail.repository;
//package com.bitacademy.cocktail.repository;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;
//
//import com.bitacademy.cocktail.domain.Signature;
//
//@Repository
//@Transactional
//public class SignatureRepository1 {
//	
//	private final EntityManager em;
//	
//	public SignatureRepository1(EntityManager em) {
//		this.em = em;
//	}
//
//	public Signature add(Signature signature) {
//		em.persist(signature);
//		return signature;
//	}
//
//	public List<Signature> findAll() {
//		List<Signature> result = em.createQuery("select m from signature m", Signature.class).getResultList();
//		return result;
//	}
//	
//	public Signature findByNo(Long no) {
//		return em.find(Signature.class, no);
//	}
//
//	public void deleteByNo(Long no) {
//		em.remove(no);
//	}
//}
