package com.bitacademy.cocktail.repository;

import java.io.File;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bitacademy.cocktail.domain.Banner;

public interface BannerRepository extends JpaRepository<Banner, Long> {

	void deleteByNo(Long no);
	
	Banner findByNo(Long no);
	
//	@Query("select b.filepath from Banner b")
//	List<String> findAllByFilepath();

}