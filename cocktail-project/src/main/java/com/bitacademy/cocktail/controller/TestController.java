package com.bitacademy.cocktail.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitacademy.cocktail.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
	private final TestService testService;
	
	private TestController(TestService testService) {
		this.testService = testService;
	}

}
