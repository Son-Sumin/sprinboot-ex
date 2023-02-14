package com.bitacademy.cocktail.domain;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bitacademy.cocktail.base.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="reviewSignature")
@Data
@EqualsAndHashCode(callSuper=false)
@ToString(exclude = "signature")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewSignature extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;

	private String nickname;

	private String contents;
	
	@ManyToOne(targetEntity = Signature.class)
	@JsonIgnore
    @JoinColumn(name = "signature_no", insertable=false, updatable=false)
    private Signature signature;

	
//	public void updateSignature(Signature signature) {
//        this.signature = signature;
//    }

	
//	@Builder
//    public ReviewSignature(String nickname, String contents, Signature signature) {
//        this.nickname = nickname;
//        this. contents =  contents;
//        if(this.signature != null) {
//        	signature.getReviewSignature().remove(this);
//        } else
//            this.signature = signature;
//    }
//	
//	public ReviewSignature toEntity() {
//		return ReviewSignature.builder()
//				.nickname(nickname)
//				.contents(contents)
//				.signature(signature)
//				.build();
//	}
}
