package com.bitacademy.cocktail.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.bitacademy.cocktail.base.BaseTimeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name="signature")
@Data
@Builder
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class Signature extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;

	private String nickname;

	@Column(name = "cocktail_name")
	private String cocktailName;

	@Column(name = "cocktail_contents")
	private String cocktailContents;

	@Column(name = "recipe_contents")
	private String recipeContents;

	private String type;
	
	@OneToMany(mappedBy = "signature")
	private List<ReviewSignature> reviewSignature;

}





//	@Column(name = "reg_date", updatable = false)
//	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	private Instant regDate;
//
//	@Column(name = "mod_date")
//	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
//	private Instant modDate;


//	@PrePersist
//    public void prePersist(){
//		this.regDate = Instant.now();
//		this.modDate = Instant.now();
//    }
//
//    @PreUpdate
//    public void preUpdate(){
//    	this.modDate = Instant.now();
//    }

//    public void dateFormat() {
//    	Instant instant = Instant.now();
//    	ZoneId zone = ZoneId.systemDefault();
//    	ZonedDateTime zonedDateTime = instant.atZone(zone);
//    }
