package com.bitacademy.cocktail.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.bitacademy.cocktail.base.BaseTimeEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="signature")
@Table
@Getter @Setter @ToString  @RequiredArgsConstructor
public class Signature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	private String nickname;
	
	@Column(name = "cocktail_name")
	private String cocktailName;
	
	@Column(name = "reg_date")
	private LocalDateTime createdAt;
	
//	@Column(nullable = true)
//	private LocalDateTime updateAt;
	
	@Column(name = "cocktail_contents")
	private String cocktailContents;
	
	@Column(name = "recipe_contents")
	private String recipeContents;
	
	private String type;
	
	
	@PrePersist
    public void prePersist(){
		this.createdAt = LocalDateTime.now();
       // this.updateAt = LocalDateTime.now();
    }

//    @PreUpdate
//    public void preUpdate(){
//    	this.updateAt = LocalDateTime.now();
//    }

	
//	@PrePersist
//	public void createdAt() {
//		this.createdAt = LocalDateTime.now();
//	}
//	
//	@PreUpdate
//    public void preUpdate() {
//        super.preUpdate();
//    }
}
