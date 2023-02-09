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
	
	/* 해당 시그니처 게시글 리스트 */
	public List<ReviewSignature> listReviewSignature() {
		return reviewSignatureRepository.findAll();
	}
	
	/* 댓글 작성 */
	public void add(ReviewSignature form) {
		ReviewSignature reviewSignature = new ReviewSignature();
		
		reviewSignature.setNickname(form.getNickname());
		reviewSignature.setContents(form.getContents());
		
		reviewSignatureRepository.save(reviewSignature);
		
	}
}
