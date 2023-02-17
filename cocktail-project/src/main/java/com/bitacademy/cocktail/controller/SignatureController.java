package com.bitacademy.cocktail.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.cocktail.domain.ReviewSignature;
import com.bitacademy.cocktail.domain.Signature;
import com.bitacademy.cocktail.service.CocktailRecipeService;
import com.bitacademy.cocktail.service.CocktailService;
import com.bitacademy.cocktail.service.ReviewSignatureService;
import com.bitacademy.cocktail.service.SignatureService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/signature")
@RequiredArgsConstructor
public class SignatureController {

	/* SignatureService, ReviewSignatureService 생성자 주입 */
	private final SignatureService signatureService;
	private final ReviewSignatureService reviewSignatureService;
	
	/* 시그니처 리스트 */
	@GetMapping({"", "/list"})
	public String list(Model model) {
		List<Signature> signature = signatureService.listSignature();
		model.addAttribute("signatures", signature);
		return "signature/signatureList";
	}

	/* 시그니처 글 작성폼 */
	@GetMapping("/form")
	public String writeSignature() {
		return "signature/signatureForm";
	}

	/* 시그니처 글 작성 */
	@PostMapping("/form")
	public String writeSignature(@ModelAttribute Signature signature) {
		signatureService.add(signature);
		return "redirect:/signature";
	}

	/* 시그니처 게시글 보기 + 조회수 + 해당 게시글 댓글 리스트 */
	@GetMapping("/view/{no}")
	public String view(@PathVariable("no") Long no, Model model) {
		// 시그니처 게시글 보기
		model.addAttribute("signature", signatureService.findSigView(no));
		
		// 조회수
		signatureService.updateHit(no);
		
		// 해당 게시글 댓글 리스트
		List<ReviewSignature> reviewSignature = reviewSignatureService.listReviewSignature(no);
		model.addAttribute("reviewSignatures", reviewSignature);
		
		return "signature/signatureView";
	}
	
	/* 시그니처 게시글 좋아요 */
	@GetMapping("/view/like/{no}")
	public String likeSig(@PathVariable("no") Long no,  Model model) {
		model.addAttribute("signature", signatureService.findSigView(no));
		signatureService.updateLike(no);
		return "redirect:/signature";
	}

	/* 시그니처 게시글 삭제 */
	@GetMapping("/delete/{no}")
	public String delete(@PathVariable("no") Long no) {
		signatureService.delete(no);
		return "redirect:/signature/list";
	}

	/* 시그니처 게시글 수정폼 */
	@GetMapping("/modify/{no}")
	public String modify(@PathVariable("no") Long no, Model model) {
		// 기존 글 담아오기
		model.addAttribute("signature", signatureService.findSigView(no));
		return "signature/signatureModify";
	}

	/* 시그니처 게시글 수정 */
	@PostMapping("/modify/{no}")
	public String modify(@PathVariable("no") Long no, @ModelAttribute Signature signature) {
		signatureService.modify(signature);
		return "redirect:/signature";
	}
	
	/* 시그니처 게시글 댓글 작성 */
	@PostMapping("/view/{no}/review/write")
	public String writeReviewSig(
			@PathVariable("no") Long no,
			@ModelAttribute ReviewSignature reviewSignature) {	
		reviewSignature.setNo(null);
		reviewSignatureService.add(no, reviewSignature);
		return "redirect:/signature/view/" + no;
	}
	
	/* 시그니처 게시글 댓글 삭제 */
	@GetMapping("/view/{no}/review/delete/{reviewNo}")
	public String deleteReviewSig(
			@PathVariable("no") Long no,
			@PathVariable("reviewNo") Long reviewNo,
			@ModelAttribute ReviewSignature reviewSignature) {
		reviewSignature.setSignature(signatureService.findSigView(no));
		reviewSignatureService.delete(no, reviewNo, reviewSignature);
		return "redirect:/signature/view/" + no;
	}

}
