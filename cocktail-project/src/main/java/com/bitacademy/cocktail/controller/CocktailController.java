package com.bitacademy.cocktail.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.cocktail.domain.Cocktail;
import com.bitacademy.cocktail.domain.CocktailRecipe;
import com.bitacademy.cocktail.service.CocktailRecipeService;
import com.bitacademy.cocktail.service.CocktailService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/cocktail")
@RequiredArgsConstructor
public class CocktailController {
	
	/* CocktailService, CocktailRecipeService 생성자 주입 */
	private final CocktailService cocktailService;
	private final CocktailRecipeService cocktailRecipeService;
	
	/* 칵테일 목록 */
	@GetMapping({"", "/list"})
	public String list(Model model, Long no) {
		List<Cocktail> cocktail = cocktailService.listCocktail();
		model.addAttribute("cocktails", cocktail);
		return "cocktail/cocktailList";
	}

	/* 칵테일 작성 폼 */
	@GetMapping("/form")
	public String cocktailForm() {
		return "cocktail/cocktailForm";
	}

	/* 칵테일 글 작성 */
	@PostMapping("/form")
	public String enrollCocktail(@ModelAttribute Cocktail form) {

		Cocktail cocktail = new Cocktail();

		cocktail.setType(form.getType());
		cocktail.setName(form.getName());
		cocktail.setEngName(form.getEngName());
		cocktail.setCocktailContents(form.getCocktailContents());
		cocktail.setRecipeContents(form.getRecipeContents());

		cocktailService.add(cocktail);
		return "redirect:/";
	}

	/* 칵테일 게시글 보기 + 칵테일별 재료 목록 */
	@GetMapping("/view/{no}")
	public String view(@PathVariable("no") Long no, Model model, CocktailRecipe cocktailRecipe) {
		// 칵테일 게시글 보기
		model.addAttribute("cocktail", cocktailService.findCocktailView(no));
		
		//칵테일별 재료 목록
		List<CocktailRecipe> list =  cocktailRecipeService.findByCocktail(no, cocktailRecipe);
		model.addAttribute("cocktailRecipes", list);
		
		return "cocktail/cocktailView";
	}
	
}