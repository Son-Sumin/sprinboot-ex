package com.bitacademy.cocktail.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

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
	public void add(Signature signature) {
		signatureRepository.save(signature);
	}
	
	/* 글 수정 */
	public void modify(Signature signature) {
		signatureRepository.save(signature);
	}
	
	/* 글 삭제 */
	public void delete(Long no) {
		signatureRepository.deleteByNo(no);
	}
}
