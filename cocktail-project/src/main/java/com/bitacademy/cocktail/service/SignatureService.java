package com.bitacademy.cocktail.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bitacademy.cocktail.domain.Signature;
import com.bitacademy.cocktail.repository.SignatureRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SignatureService {

	/* SignatureRepository 생성자 주입 */
	private final SignatureRepository signatureRepository;

	/* 시그니처 리스트 */
	public List<Signature> listSignature() {
		return signatureRepository.findAll();
	}

	/* 시그니처 1개 게시글 보기 */
	public Signature findSigView(Long no) {
		return signatureRepository.findByNo(no).get();
	}

	/* 시그니처 작성 */
	public Signature add(Signature form) {
		
		Signature signature = new Signature();

		signature.setNickname(form.getNickname());
		signature.setCocktailName(form.getCocktailName());
		signature.setCocktailContents(form.getCocktailContents());
		signature.setRecipeContents(form.getRecipeContents());
		signature.setType(form.getType());
		signature.setHit(0);
		signature.setLike(0);
		
		return signatureRepository.save(signature);
	}

	/* 글 삭제 */
	public void delete(Long no) {
		signatureRepository.deleteByNo(no);
	}

	/* 글 수정 */
	public void modify(Signature signature) {
		signatureRepository.save(signature);
	}
	
	/* 조회수 올리기 */
	public void updateHit(Long no) {
		signatureRepository.updateHit(no);
	}
	
	/* 좋아요 올리기 */
	public void updateLike(Long no) {
		signatureRepository.updateLike(no);
	}
	
}
