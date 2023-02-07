package com.bitacademy.cocktail.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bitacademy.cocktail.base.BaseTimeEntity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name="reviewSignature")
@Data
@Builder
@EqualsAndHashCode(callSuper=false)
public class ReviewSignature extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	private String nickname;
	
	private String contents;

}
