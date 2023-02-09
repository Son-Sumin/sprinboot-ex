package com.bitacademy.cocktail.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bitacademy.cocktail.domain.ReviewSignature;
import com.bitacademy.cocktail.domain.Signature;
import com.bitacademy.cocktail.repository.ReviewSignatureRepository;
import com.bitacademy.cocktail.repository.SignatureRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewSignatureService {
	
	private final ReviewSignatureRepository reviewSignatureRepository;
	private final SignatureRepository signatureRepository;

//	/* 해당 시그니처 게시글 리스트 */
//	public List<ReviewSignature> listReviewSignature() {
//		return reviewSignatureRepository.findAll();
//	}
	
	/* 댓글 작성 */
	public void add(ReviewSignature form) {
		
		Optional<Signature> findBoard = signatureRepository.findByNo(no);
		
		ReviewSignature reviewSignature = new ReviewSignature();
		
		reviewSignature.setNickname(form.getNickname());
		reviewSignature.setContents(form.getContents());
		
		reviewSignatureRepository.save(reviewSignature);
		
	}
}
