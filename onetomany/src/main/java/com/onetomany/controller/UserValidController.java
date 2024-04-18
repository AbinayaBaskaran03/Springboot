package com.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onetomany.entity.UserValidation;
import com.onetomany.service.UserValidService;

@RestController
@RequestMapping("/user")
@Validated
public class UserValidController {
	
	@Autowired
	public UserValidService userValidService;
	
	@PostMapping(value = "/validuser")
	public ResponseEntity<String> createUser(@RequestBody UserValidation validuser) throws RuntimeException{
		UserValidation validUsername =  userValidService.findByUsername(validuser.getUserName());
		if(null!= validUsername) {
			throw new RuntimeException("Duplicate username");	
		}
		UserValidation validfirstname =  userValidService.findByFirstname(validuser.getFirstName());
		if(null!= validfirstname) {
			throw new RuntimeException("Duplicate firstname ");	
		}
		UserValidation validlastname =  userValidService.findByLastname(validuser.getLastName());
		if(null!= validlastname) {
			throw new RuntimeException("Duplicate lastname ");	
		}
		
		UserValidation validemail =  userValidService.findByEmailId(validuser.getEmail());
		if(null!= validemail) {
			throw new RuntimeException("Duplicate email");	
		}
		UserValidation validmobileno =  userValidService.findByMobileno(validuser.getMobileNo());
		if(null!= validmobileno) {
			throw new RuntimeException("Duplicate mobileno");	
		}
		UserValidation validaddress =  userValidService.findByAddress(validuser.getAddress());
		if(null!= validaddress) {
			throw new RuntimeException("Duplicate address");	
		}
		UserValidation validpincode =  userValidService.findByPincode(validuser.getPinCode());
		if(null!= validpincode) {
			throw new RuntimeException("Duplicate pincode ");	
		}
		
		userValidService.saveUserValid(validuser);
		  return ResponseEntity.internalServerError().body("Duplicate value " );

	}
	 
}
