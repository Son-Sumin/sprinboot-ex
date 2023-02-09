package com.bitacademy.cocktail.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.cocktail.domain.Ingredient;
import com.bitacademy.cocktail.service.IngredientService;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
	private final IngredientService ingredientService;

	private IngredientController(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}

	/* 재료 목록 */
	@GetMapping({"", "/list"})
	public String list(Model model) {
		List<Ingredient> ingredient = ingredientService.listIngredient();
		model.addAttribute("ingredient", ingredient);
		
		return "ingredient/ingredientList";
	}
	
	/* 재료 게시글 보기 */
	@GetMapping("/view")
	public String view(Long no, Model model) {
		model.addAttribute("ingredient", ingredientService.findIngreView(no));
		return "ingredient/ingredientView";
	}
}
