package com.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onetomany.entity.CusValidation;
import com.onetomany.service.CusValidService;

@RestController
@RequestMapping("/cus")

public class CusValidController {

	@Autowired
	public CusValidService cusValidService;

	@PostMapping(value = "/validcus")
	public ResponseEntity<String> createCusvalid(@RequestBody CusValidation cusValidation) {
		try {
			CusValidation validEmail = cusValidService.findByEmailId(cusValidation.getEmail());

			if (null != validEmail) {
				throw new Exception("duplicate mail value");
			}
			CusValidation validPhone = cusValidService.findByPhoneNo(cusValidation.getPhone());

			if (null != validPhone) {
				throw new Exception("duplicate phone value");
			}
			cusValidService.saveCusValid(cusValidation);
			return ResponseEntity.ok("Email and phone sent successfully");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error Occured: " + e);
		}
	}
}
