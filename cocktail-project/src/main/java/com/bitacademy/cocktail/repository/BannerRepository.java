package com.bitacademy.cocktail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.bitacademy.cocktail.domain.Banner;

public interface BannerRepository extends JpaRepository<Banner, Long> {

	void deleteByNo(Long no);
	
	Banner findByNo(Long no);

	//void saveAll(List<byte[]> res);

}