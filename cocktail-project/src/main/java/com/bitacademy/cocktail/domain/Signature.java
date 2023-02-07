package com.bitacademy.cocktail.domain;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="signature")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Signature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	private String nickname;
	
	@Column(name = "cocktail_name")
	private String cocktailName;
	
	@Column(name = "reg_date", updatable = false)
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Instant regDate;
	
	@Column(name = "mod_date")
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Instant modDate;
	
	@Column(name = "cocktail_contents")
	private String cocktailContents;
	
	@Column(name = "recipe_contents")
	private String recipeContents;
	
	private String type;

	
	@PrePersist
    public void prePersist(){
		this.regDate = Instant.now();
		this.modDate = Instant.now();
		
//		Instant instant = Instant.now();
//    	ZoneId zone = ZoneId.systemDefault();
//    	this.regDate = instant.atZone(zone);
//    	this.modDate = instant.atZone(zone);
    }

    @PreUpdate
    public void preUpdate(){
    	this.modDate = Instant.now();
    	
//    	Instant instant = Instant.now();
//    	ZoneId zone = ZoneId.systemDefault();
//    	this.modDate = instant.atZone(zone);
    }
    
//    public void dateFormat() {
//    	Instant instant = Instant.now();
//    	ZoneId zone = ZoneId.systemDefault();
//    	ZonedDateTime zonedDateTime = instant.atZone(zone); 
//    }

}
