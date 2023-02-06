package com.bitacademy.cocktail.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

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
	private LocalDateTime regDate;
	
	@Column(name = "mod_date")
	private LocalDateTime modDate;
	
	@Column(name = "cocktail_contents")
	private String cocktailContents;
	
	@Column(name = "recipe_contents")
	private String recipeContents;
	
	private String type;

	
	@PrePersist
    public void prePersist(){
		this.regDate = LocalDateTime.now();
		this.modDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
    	this.modDate = LocalDateTime.now();
    }

}
