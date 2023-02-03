package com.bitacademy.cocktail.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitacademy.cocktail.domain.Cocktail;;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
	
	Optional<Cocktail> findByNo(Long no);
	
}
