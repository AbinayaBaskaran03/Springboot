package com.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onetomany.entity.Address;
import com.onetomany.service.AddressService;

@RestController
@RequestMapping("/OnetoMany")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	 @PostMapping(value = "/create")
		public  Address createaddress(@RequestBody Address address) {
		addressService.saveAddress(address);
	    return address;
	   }

}
