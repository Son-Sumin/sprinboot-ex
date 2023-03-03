package com.bitacademy.cocktail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bitacademy.cocktail.domain.Banner;

public interface BannerRepository extends JpaRepository<Banner, Long> {

	void deleteByNo(Long no);
	
	Banner findByNo(Long no);

	//byte[] findByFilename(String filename);
	
	@Query(value = "select concat('/banner/list', filepath) from banner",
			nativeQuery = true)
	List<Banner> findFilepath();

}