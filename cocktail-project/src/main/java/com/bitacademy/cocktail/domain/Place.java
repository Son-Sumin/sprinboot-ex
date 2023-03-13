package com.bitacademy.cocktail.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.geolatte.geom.Point;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Place {
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;                    

    @Column(length = 20)
    private String placeName;            

    @Column(nullable = false, columnDefinition = "GEOMETRY")
    private Point geography;
}