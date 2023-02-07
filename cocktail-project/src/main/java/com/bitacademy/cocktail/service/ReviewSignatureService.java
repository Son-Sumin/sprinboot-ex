package com.bitacademy.cocktail.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bitacademy.cocktail.domain.ReviewSignature;
import com.bitacademy.cocktail.repository.ReviewSignatureRepository;

@Service
@Transactional
public class ReviewSignatureService {
private final ReviewSignatureRepository reviewSignatureRepository;
	
	public ReviewSignatureService(ReviewSignatureRepository reviewSignatureRepository) {
		this.reviewSignatureRepository = reviewSignatureRepository;
	}

	public List<ReviewSignature> listReviewSignature() {
		return reviewSignatureRepository.findAll();
	}
}
