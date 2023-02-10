package com.bitacademy.cocktail.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.cocktail.domain.Cocktail;
import com.bitacademy.cocktail.domain.CocktailImage;
import com.bitacademy.cocktail.service.CocktailImageService;
import com.bitacademy.cocktail.service.CocktailService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/cocktail")
@RequiredArgsConstructor
public class CocktailController {
	
	/* CocktailService, CocktailImageService 생성자 주입 */
	private final CocktailService cocktailService;
	private final CocktailImageService cocktailImageService;

	/* 칵테일 목록 */
	@GetMapping({"", "/list"})
	public String list(Model model, Long no) {
		List<Cocktail> cocktail = cocktailService.listCocktail();
		List<CocktailImage> cocktailImageUrl = cocktailImageService.listCocktailImageUrl(no);
		model.addAttribute("cocktail", cocktail);
		model.addAttribute("cocktailImageUrl", cocktailImageUrl);
		
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

	/* 칵테일 게시글 보기 */
	@GetMapping("/view")
	public String view(Long no, Model model) {
		model.addAttribute("cocktail", cocktailService.findSigView(no));
		return "cocktail/cocktailView";
	}
}