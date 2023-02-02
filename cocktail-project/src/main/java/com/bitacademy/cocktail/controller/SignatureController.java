package com.bitacademy.cocktail.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/signature")
	public String list(Model model) {
		List<Signature> signature = signatureService.listSignature();
		model.addAttribute("signature", signature);
		return "signature";
	}
	
	@GetMapping("/signature/view")
	public String view(Long no, Model model) {
		model.addAttribute("signature", signatureService.findSigContents(no));
		return "signatureView";
	}
	
	@GetMapping("/signature/modify")
	public String modify(Long no, Model model) {;
		model.addAttribute("signature", signatureService.findSigContents(no));
		return "signatureView";
	}
	
	@GetMapping("/signature/reply")
	public String reply(Long no, Model model) {
		model.addAttribute("signature", signatureService.findSigContents(no));
		return "signatureView";
	}
	
	@GetMapping("/signatureForm")
	public String signatureForm() {
		return "signatureForm";
	}
	
	@PostMapping("/signatureForm")
	public String enrollSignature(Signature form) {
		Signature signature = new Signature();
		signature.setNickname(form.getNickname());
		signature.setCocktailName(form.getCocktailName());
		signature.setRegDate(form.getRegDate());
		signature.setCocktailContents(form.getCocktailContents());
		signature.setRecipeContents(form.getRecipeContents());
		signature.setType(form.getType());
		
		signatureService.add(signature);
		return "redirect:/";
	}
}
