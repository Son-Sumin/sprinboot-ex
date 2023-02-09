package com.bitacademy.cocktail.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitacademy.cocktail.domain.Signature;

public interface SignatureRepository extends JpaRepository<Signature, Long> {

	Signature findByNo(Long no);

	void deleteByNo(Long no);

}