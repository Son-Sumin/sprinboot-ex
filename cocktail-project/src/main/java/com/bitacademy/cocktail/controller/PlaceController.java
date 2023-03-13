package com.bitacademy.cocktail.controller;

import org.geolatte.geom.Point;
import org.locationtech.jts.io.WKTReader;
import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitacademy.cocktail.domain.Place;
import com.bitacademy.cocktail.service.PlaceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class PlaceController {
	
	/* 생성자 주입 */
	private final PlaceService placeService;

    public void createCafe(@ModelAttribute Place place) {
    	

    	
    	
        placeService.createPlace(place);
    }
}
