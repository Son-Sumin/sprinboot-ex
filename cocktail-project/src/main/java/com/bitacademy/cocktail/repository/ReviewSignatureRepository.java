package com.bitacademy.cocktail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.bitacademy.cocktail.domain.ReviewSignature;

public interface ReviewSignatureRepository extends JpaRepository<ReviewSignature, Long> {
	
	List<ReviewSignature> findBySignatureNo(@Param("no") Long signatureNo);

	void deleteByNo(Long no);

	ReviewSignature findByNo(Long no);

}
