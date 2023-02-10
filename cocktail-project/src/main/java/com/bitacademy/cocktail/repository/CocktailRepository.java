package com.bitacademy.cocktail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitacademy.cocktail.domain.Cocktail;;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {

	Cocktail findByNo(Long no);

//	@Query(value = "select c.*, a.url "
//			+ "from cocktail as c, cocktailImage as a "
//			+ "where c.no = a.cocktail_no",
//			nativeQuery = true)
//	List<Cocktail> findAll();
}
