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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity(name="signature")
@Table
@Data
public class Signature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	private String nickname;
	
	@Column(name = "cocktail_name")
	private String cocktailName;
	
	@CreationTimestamp
	@Column(name = "reg_date")
	//private String regDate;
	private LocalDateTime createdAt;
	
//	@UpdateTimestamp
//	@Column(name = "reg_date")
//	private LocalDateTime updDate;
	
	@Column(name = "cocktail_contents")
	private String cocktailContents;
	
	@Column(name = "recipe_contents")
	private String recipeContents;
	
	private String type;
	
	
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
