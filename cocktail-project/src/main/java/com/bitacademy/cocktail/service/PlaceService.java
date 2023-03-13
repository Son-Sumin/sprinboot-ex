package com.bitacademy.cocktail.service;

import org.geolatte.geom.Point;
import org.locationtech.jts.io.WKTReader;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitacademy.cocktail.domain.Place;
import com.bitacademy.cocktail.repository.PlaceRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PlaceService {
	
	/* 생성자 주입 */
	private final PlaceRepository placeRepository;

	/* 위치 추가하기 */
	public void createPlace(Place place) throws ParseException {
		
    	String newPlaceName = place.getPlaceName();
    	String pointWKT = String.format("POINT(%s %s)", place.getLongitude(), place.getLatitude());
//        Point point = (Point) new WKTReader().read(pointWKT);
//        Place newPlace = new Place(newPlaceName, point);
        
//        Place newPlace = Place.builder()
//                .placeName(place.getPlaceName())
//                .location(point)
//                .build();
//		placeRepository.save(newPlace);
		
	}

}
