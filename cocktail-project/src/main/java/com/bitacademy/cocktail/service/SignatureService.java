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
		
		public void add(Signature signature) {
			signatureRepository.save(signature);
		}
		
		public List<Signature> listSignature() {
			return signatureRepository.findAll();
		}

		public Signature findSigView(Long no) {
			return signatureRepository.findByNo(no);
		}
		
		public void delete(Long no) {
			signatureRepository.deleteByNo(no);
		}
}
