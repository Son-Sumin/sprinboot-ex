package com.bitacademy.cocktail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bitacademy.cocktail.domain.Cocktail;;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Long> {

	Cocktail findByNo(Long no);

	@Override
	@Query("select a.*, b.url"
			+ " from cocktail a, cocktailimage"
			+ " where a.no = b.cocktail_no")
	List<Cocktail> findAll();
}
