package com.spring.jpa.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.entity.CusAddress;
import com.spring.jpa.service.CustomerService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/create")
	public CusAddress createcustomer(@RequestBody CusAddress address) {
		customerService.saveAddress(address);
		return address;
	}
    @GetMapping(value = "/get")
    public  List<CusAddress> getAllcustomer() {
    return customerService.getAllAddress();
     	}
    
    @DeleteMapping(value = "/delete/{id}")
    public void deleteAddress(@PathVariable UUID id ) {
    	customerService.deleteAddres(id);
    }
}
