package com.bitacademy.cocktail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bitacademy.cocktail.domain.Cocktail;
import com.bitacademy.cocktail.service.CocktailService;

@Controller
public class CocktailController {
	private final CocktailService cocktailService;
	
	@Autowired
	private CocktailController(CocktailService cocktailService) {
		this.cocktailService = cocktailService;
	}
	
	@GetMapping("/cocktail")
	public String list(Model model) {
		List<Cocktail> cocktail = cocktailService.listCocktail();
		model.addAttribute("cocktail", cocktail);
		return "cocktail";
	}
	
	@GetMapping("/cocktailForm")
	public String cocktailForm() {
		return "cocktailForm";
	}
	
	@PostMapping("/cocktailForm")
	public String enrollCocktail(Cocktail form) {
		Cocktail cocktail = new Cocktail();
		cocktail.setType(form.getType());
		cocktail.setName(form.getName());
		cocktail.setEngName(form.getEngName());
		cocktail.setCocktailContents(form.getCocktailContents());
		cocktail.setRecipeContents(form.getRecipeContents());
		
		cocktailService.add(cocktail);
		return "redirect:/";
	}
}

