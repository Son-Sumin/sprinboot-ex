package com.bitacademy.cocktail.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bitacademy.cocktail.domain.Signature;
import com.bitacademy.cocktail.repository.SignatureRepository;

@Service
@Transactional
public class SignatureService {
	
	private final SignatureRepository signatureRepository;
		
	public SignatureService(SignatureRepository signatureRepository) {
		this.signatureRepository = signatureRepository;
	}
	
	/* 시그니처 리스트 */
	public List<Signature> listSignature() {
		return signatureRepository.findAll();
	}
	
	/* 1개 글 보기 */
	public Signature findSigView(Long no) {
		return signatureRepository.findByNo(no);
	}
	
	/* 글 생성 */
	public void add(Signature form) {
		
		Signature signature = new Signature();
		
		signature.setNickname(form.getNickname());
		signature.setCocktailName(form.getCocktailName());
		signature.setCocktailContents(form.getCocktailContents());
		signature.setRecipeContents(form.getRecipeContents());
		signature.setType(form.getType());
		
		signatureRepository.save(signature);
	}
	
	/* 글 삭제 */
	public void delete(Long no) {
		signatureRepository.deleteByNo(no);
	}
	
	/* 글 수정 */
	public void modify(Signature signature) {
		
//		signature.setNickname(signature.getNickname());
//		signature.setCocktailName(signature.getCocktailName());
//		signature.setCocktailContents(signature.getCocktailContents());
//		signature.setRecipeContents(signature.getRecipeContents());
//		signature.setType(signature.getType());
		
		signatureRepository.save(signature);
	}
	
	
//	public void modify(Signature signature) {
//		signatureRepository.save(signature);
//	}
	

}
