package com.onetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomany.entity.UserValidation;
import com.onetomany.repository.UserValidRepository;

@Service
public class UserValidService {

	@Autowired
	
	public UserValidRepository userValidRepository;

	public UserValidation findByUsername(String user_name) {
		return userValidRepository.findByUserName(user_name);
	}

	public UserValidation findByFirstname(String first_name) {
		return userValidRepository.findByFirstName(first_name);
	}

	public UserValidation findByLastname(String last_name) {
		return userValidRepository.findByLastName(last_name);
	}

	public UserValidation findByEmailId(String email) {
		return userValidRepository.findByEmail(email);
	}

	public UserValidation findByMobileno(String mobileno) {
		return userValidRepository.findByMobileNo(mobileno);
	}

	public UserValidation findByAddress(String address) {
		return userValidRepository.findByAddress(address);
	}

	public UserValidation findByPincode(String pincode) {
		return userValidRepository.findByPinCode(pincode);
	}

	public void saveUserValid(UserValidation userValidation) {
		userValidRepository.save(userValidation);
	}
}
