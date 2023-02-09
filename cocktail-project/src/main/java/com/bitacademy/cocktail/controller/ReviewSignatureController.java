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
@RequestMapping("/signature")
public class ReviewSignatureController {

	/* ReviewSignatureService 생성자 주입 */
	private final ReviewSignatureService reviewSignatureService;
	
	/* 시그니처 댓글 작성 */
	@PostMapping("/review/{no}")
	public String addReviewSig(
			@PathVariable("no") Long no,
			@ModelAttribute ReviewSignature reviewSignature) {
		reviewSignatureService.add(no, reviewSignature);
		return "redirect:/signature";
		
		
		
		//model.addAttribute("signature", signatureService.findSigView(signature_no));
		//reviewSignatureService.add(signature_no, reviewSignature, model);
		//return "redirect:/signature";
	}

	/* 한 시그니처에 달린 댓글 리스트 */
	@GetMapping("/view/{no}")
	public String list(@PathVariable("no") Long no, Model model) {
		List<ReviewSignature> reviewSignature = reviewSignatureService.listReviewSignature(no);
		model.addAttribute("reviewSignature", reviewSignature);
		return "signature/signatureView";
	}
	

	
//	/* 시그니처 댓글 삭제 */
//	@GetMapping("/delete/{no}")
//	public String delete(@PathVariable("no") Long no) {
//		reviewSignatureService.delete(no);
//		return "redirect:/signature/list";
//	}
}
