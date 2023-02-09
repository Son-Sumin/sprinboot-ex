package com.bitacademy.cocktail.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.cocktail.domain.ReviewSignature;
import com.bitacademy.cocktail.service.ReviewSignatureService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/signature")
public class ReviewSignatureController {

	/* ReviewSignatureService 생성자 주입 */
	private final ReviewSignatureService reviewSignatureService;

//	/* 한 시그니처에 달린 댓글 리스트 */
//	@GetMapping("/view/{no}")
//	public String list(@PathVariable("no") Long no, Model model) {
//		List<ReviewSignature> reviewSignature = reviewSignatureService.listReviewSignature();
//		model.addAttribute("reviewSignature", reviewSignature);
//		return "signature/signatureView";
//	}
	
	/* 시그니처 글 작성 */
	@PostMapping("/view/{no}")
	public String writeReviewSig(
			@PathVariable("no") Long cocktail_no,
			@ModelAttribute ReviewSignature reviewSignature) {
		reviewSignatureService.add(reviewSignature);
		return "redirect:/signature";
	}
}
