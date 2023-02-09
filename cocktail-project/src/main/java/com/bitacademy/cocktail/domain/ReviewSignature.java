package com.bitacademy.cocktail.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bitacademy.cocktail.base.BaseTimeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name="reviewSignature")
@Data
@Builder
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class ReviewSignature extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;

	private String nickname;

	private String contents;
	
	@ManyToOne
    @JoinColumn(name = "signature_no", insertable=false, updatable=false)
    private Signature signature;
	
//	 @Override
//	    public boolean equals(Object o) {
//	        if (this == o) return true;
//	        if (o == null || getClass() != o.getClass()) return false;
//	        ReviewSignature reviewSignature = (ReviewSignature) o;
//	        return Objects.equals(no, reviewSignature.no) &&
//	                Objects.equals(nickname, reviewSignature.nickname) &&
//	                Objects.equals(contents, reviewSignature.contents);
//	    }
//
//	    @Override
//	    public int hashCode() {
//	        return Objects.hash(no, nickname, contents);
//	    }
}
