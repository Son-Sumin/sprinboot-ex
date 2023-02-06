package com.bitacademy.cocktail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitacademy.cocktail.domain.Signature;

//@Repository
public interface SignatureRepository extends JpaRepository<Signature, Long> {

	Signature findByNo(Long no);

	void deleteByNo(Long no);
	
	
//	@Modifying(clearAutomatically = true, flushAutomatically = true)
//	@Query("update Signature s "
//			+ "set s.nickname = :nickname, "
//			+ "s.cocktail_name = :cocktailName, "
//			+ "s.reg_date = :regDate, "
//			+ "s.cocktail_contents = :cocktailContents,"
//			+ "s.recipe_contents = :recipeContents, "
//			+ "s.type = :type, "
//			+ "where s.no = :no")
//	void modifySigView(
//			@Param("nickname") String nickname,
//			@Param("cocktailName") String cocktailName,
//			@Param("regDate") LocalDateTime createdAt,
//			@Param("cocktailContents") String cocktailContents,
//			@Param("recipeContents") String recipeContents,
//			@Param("type") String type
//		);
}
