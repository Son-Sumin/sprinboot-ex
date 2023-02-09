package com.bitacademy.cocktail.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.bitacademy.cocktail.domain.ReviewSignature;
import com.bitacademy.cocktail.domain.Signature;
import com.bitacademy.cocktail.repository.ReviewSignatureRepository;
import com.bitacademy.cocktail.repository.SignatureRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewSignatureService {
	private final SignatureRepository signatureRepository;
	private final ReviewSignatureRepository reviewSignatureRepository;

//	/* 해당 시그니처 게시글 리스트 */
//	public List<ReviewSignature> listReviewSignature() {
//		return reviewSignatureRepository.findAll();
//	}
	
	/* 댓글 작성 */
	public Long saveReviewSignature(ReviewSignature reviewSignature) {
		reviewSignatureRepository.save(reviewSignature.toEntity());
		return reviewSignature.getNo();
	}
	
//	public void add(
//			@PathVariable("no") Long signature_no,
//			@ModelAttribute ReviewSignature form,
//			Model model) {
//		
//		Signature signature = signatureRepository.findByNo(signature_no);
//		ReviewSignature reviewSignature = new ReviewSignature();
//		
//		reviewSignature.setNickname(form.getNickname());
//		reviewSignature.setContents(form.getContents());
//		
//		reviewSignatureRepository.save(reviewSignature);
//		List<ReviewSignature> reviews = reviewSignatureRepository.findReviewSig(signature_no);
//		
//		model.addAttribute("reviews", reviews);
//		model.addAttribute(signature);
//		
//	}
}
