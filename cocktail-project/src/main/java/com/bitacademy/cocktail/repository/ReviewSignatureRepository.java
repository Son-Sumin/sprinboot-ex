package com.bitacademy.cocktail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.bitacademy.cocktail.domain.ReviewSignature;

public interface ReviewSignatureRepository extends JpaRepository<ReviewSignature, Long> {
	
//	@Query("select r from ReviewSignature as r where r.signature.no = :no")
//	List<ReviewSignature> findReviewSignatureNo(@Param("no") Long no);

}
