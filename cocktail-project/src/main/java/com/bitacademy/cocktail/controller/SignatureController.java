package com.bitacademy.cocktail.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bitacademy.cocktail.domain.Signature;
import com.bitacademy.cocktail.service.SignatureService;

@Controller
public class SignatureController {
	private final SignatureService signatureService;
	
	private SignatureController(SignatureService signatureService) {
		this.signatureService = signatureService;
	}
	
	/* 시그니처 리스트 */
	@GetMapping({"/signature", "/signature/list"})
	public String list(Model model) {
		List<Signature> signature = signatureService.listSignature();
		model.addAttribute("signature", signature);
		return "signature/signatureList";
	}
	
	/* 시그니처 작성폼 */
	@GetMapping("/signature/form")
	public String signatureForm() {
		return "signature/signatureForm";
	}
	
	/* 시그니처 글 작성 */
	@PostMapping("/signature/form")
	public String writeSignature(Signature form) {
		
		Signature signature = new Signature();
		
		signature.setNickname(form.getNickname());
		signature.setCocktailName(form.getCocktailName());
		signature.setCocktailContents(form.getCocktailContents());
		signature.setRecipeContents(form.getRecipeContents());
		signature.setType(form.getType());
		
		signatureService.add(signature);
		return "redirect:/";
	}
	
	/* 시그니처 게시글 보기 */
	@GetMapping("/signature/view")
	public String view(Long no, Model model) {
		model.addAttribute("signature", signatureService.findSigView(no));
		return "signature/signatureView";
	}
	
	/* 시그니처 게시글 삭제 */
	@GetMapping("/signature/delete/{no}")
	public String delete(@PathVariable("no") Long no) {;
		signatureService.delete(no);
		return "redirect:/signature/list";
	}
	
	/* 시그니처 게시글 수정폼 */
	@GetMapping("/signature/modify/{no}")
	public String modify(@PathVariable("no") Long no, Model model) {;
		model.addAttribute("signature", signatureService.findSigView(no));
		return "signature/signatureModify";
	}
	
	/* 시그니처 게시글 수정 */
	@PostMapping("/signature/modify/{no}")
	public String modify(@PathVariable("no") Long no, @ModelAttribute Signature signature) {
		
		// 기존 글 담아오기
		signature = signatureService.findSigView(no);
		
		// 수정 내용 다시 세팅하기
		signature.setNickname(signature.getNickname());
		signature.setCocktailName(signature.getCocktailName());
		signature.setRegDate(LocalDateTime.now());
		signature.setCocktailContents(signature.getCocktailContents());
		signature.setRecipeContents(signature.getRecipeContents());
		signature.setType(signature.getType());
		
		return "redirect:/signature/list";
	}
	
	/* 시그니처 게시글 답글 달기 */
	@GetMapping("/signature/reply")
	public String reply(Long no, Model model) {
		model.addAttribute("signature", signatureService.findSigView(no));
		return "signatureView";
	}
	

}