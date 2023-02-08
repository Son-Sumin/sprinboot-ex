package com.bitacademy.cocktail.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bitacademy.cocktail.domain.ReviewSignature;
import com.bitacademy.cocktail.service.ReviewSignatureService;

@Controller
public class ReviewSignatureController {

	private final ReviewSignatureService reviewSignatureService;

	public ReviewSignatureController(ReviewSignatureService reviewSignatureService) {
		this.reviewSignatureService = reviewSignatureService;
	}

	/* 한 시그니처에 달린 댓글 리스트 */
	@GetMapping("/view/{no}")
	public String list(@PathVariable("no") Long no, Model model) {
		List<ReviewSignature> reviewSignature = reviewSignatureService.listReviewSignature();
		model.addAttribute("reviewSignature", reviewSignature);
		return "signature/signatureView";
	}
}
