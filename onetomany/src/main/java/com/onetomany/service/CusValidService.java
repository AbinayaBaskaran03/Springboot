package com.onetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomany.entity.CusValidation;
import com.onetomany.repository.CusValidRepository;

@Service
public class CusValidService {

	@Autowired
	public CusValidRepository cusValidRepository;

	public CusValidation findByEmailId(String email) {
		return cusValidRepository.findByEmail(email);
	}

	public CusValidation findByPhoneNo(String phone) {
		return cusValidRepository.findByPhone(phone);
	}

	public void saveCusValid(CusValidation cusValidation) {
		cusValidRepository.save(cusValidation);
	}
	
}
