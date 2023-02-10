// 사용 X


package com.bitacademy.cocktail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitacademy.cocktail.domain.CocktailImage;;

@Repository
public interface CocktailImageRepository extends JpaRepository<CocktailImage, Long> {

	CocktailImage findByCocktailNo(Long no);

	List<CocktailImage> findUrlByCocktailNo(Long no);
}
