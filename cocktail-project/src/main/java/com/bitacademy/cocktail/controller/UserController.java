package com.bitacademy.cocktail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.cocktail.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	private UserController(UserService userService) {
		this.userService = userService;
	}
}
