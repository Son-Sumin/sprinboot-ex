//package com.bitacademy.cocktail.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.bitacademy.cocktail.service.CocktailService3;
//import com.bitacademy.cocktail.service.ReviewSignatureService;
//import com.bitacademy.cocktail.service.SignatureService;
//
//import lombok.RequiredArgsConstructor;
//
//@Controller
//@RequiredArgsConstructor
//public class HttpController {
//	private final CocktailService3 cocktailService;
//	private final SignatureService signatureService;
//	private final ReviewSignatureService reviewSignatureService;
//
//	/* 칵테일 작성 폼 */
//	@GetMapping("/cocktail/form")
//	public String cocktailForm() {
//		return "cocktail/cocktailForm";
//	}
//
//	/* 시그니처 글 작성폼 */
//	@GetMapping("/signature/form")
//	public String writeSignature() {
//		return "signature/signatureForm";
//	}
//
//	/* 시그니처 게시글 수정폼 */
//	@GetMapping("/signature/modify/{no}")
//	public String modify(@PathVariable("no") Long no, Model model) {
//		// 기존 글 담아오기
//		model.addAttribute("signature", signatureService.findSigView(no));
//		return "signature/signatureModify";
//	}
//}
