package com.bitacademy.cocktail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitacademy.cocktail.domain.ReviewSignature;

public interface ReviewSignatureRepository extends JpaRepository<ReviewSignature, Long> {

}
