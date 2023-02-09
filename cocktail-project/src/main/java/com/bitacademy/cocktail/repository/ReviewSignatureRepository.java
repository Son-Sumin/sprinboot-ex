package com.bitacademy.cocktail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.bitacademy.cocktail.domain.ReviewSignature;

public interface ReviewSignatureRepository extends JpaRepository<ReviewSignature, Long> {
	
//	@Query(value = "select r from ReviewSignature as r "
//			+ "where r.signature.no = : r.signature_no and r.no > 0 "
//			+ "order by r.no asc",
//			nativeQuery = true)
	List<ReviewSignature> findBySignatureNo(@Param("no") Long signatureNo);

}
