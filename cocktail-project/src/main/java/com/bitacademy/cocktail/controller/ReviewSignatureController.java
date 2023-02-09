package com.bitacademy.cocktail.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bitacademy.cocktail.domain.ReviewSignature;
import com.bitacademy.cocktail.domain.Signature;
import com.bitacademy.cocktail.repository.ReviewSignatureRepository;
import com.bitacademy.cocktail.repository.SignatureRepository;
import com.bitacademy.cocktail.service.ReviewSignatureService;
import com.bitacademy.cocktail.service.SignatureService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewSignatureController {

	/* SignatureService, ReviewSignatureService 생성자 주입 */
	private final SignatureService signatureService;
	private final SignatureRepository signatureRepository;
	private final ReviewSignatureService reviewSignatureService;
	private final ReviewSignatureRepository reviewSignatureRepository;

//	/* 한 시그니처에 달린 댓글 리스트 */
//	@GetMapping("/view/{no}")
//	public String list(@PathVariable("no") Long no, Model model) {
//		List<ReviewSignature> reviewSignature = reviewSignatureService.listReviewSignature();
//		model.addAttribute("reviewSignature", reviewSignature);
//		return "signature/signatureView";
//	}
	
	/* 시그니처 댓글 작성 */
	@PostMapping("/signature/view/{no}/review")
	public String writeReviewSig(
			@PathVariable("no") Long signature_no,
			@ModelAttribute ReviewSignature reviewSignature,
			Model model) {

		
		return "redirect:/signature";
		
		
		
		//model.addAttribute("signature", signatureService.findSigView(signature_no));
		//reviewSignatureService.add(signature_no, reviewSignature, model);
		//return "redirect:/signature";
	}
}
