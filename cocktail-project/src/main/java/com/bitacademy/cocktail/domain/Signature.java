package com.bitacademy.cocktail.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.bitacademy.cocktail.base.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="signature")
@Table
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "reviewSignature")
@DynamicInsert  @DynamicUpdate 
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
	
	@ColumnDefault("0")
	private Integer hit;
	
	@ColumnDefault("0")
	private Integer like;
	
	@OneToMany(mappedBy = "signature", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"signature"})
	private List<ReviewSignature> reviewSignature;
	
	@Builder
    private Signature(String nickname, String cocktailName, String cocktailContents, String recipeContents, String type, Integer hit, Integer like) {
        this.nickname = nickname;
        this.cocktailName = cocktailName;
        this.cocktailContents = cocktailContents;
        this.recipeContents = recipeContents;
        this.type = type;
        this.hit = hit;
        this.like = like;
    }
	
//	@PrePersist
//    public void prePersistHit() {
//        this.hit = this.hit == null ? 0 : this.hit;
//    }
//	
//	@PrePersist
//    public void prePersistLike() {
//        this.like = this.like == null ? 0 : this.like;
//    }

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
