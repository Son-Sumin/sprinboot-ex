package com.bitacademy.cocktail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitacademy.cocktail.domain.Signature;

@Repository
public interface SignatureRepository extends JpaRepository<Signature, Long> {

	Signature findByNo(Long no);

	void deleteByNo(Long no);

}