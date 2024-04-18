package com.onetomany.controller;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onetomany.entity.Cus;
import com.onetomany.service.CusService;

@RestController
@RequestMapping("/OnetoMany")
public class CusController {

	@Autowired
	public CusService cusService;

	 @PostMapping(value = "/createcus")
		public  Cus createaddress(@RequestBody Cus cus) {
		 cusService.saveCus(cus);
	    return cus;
	   }
//	 @GetMapping(value = "/get")
//	  	public  List<Cus> getAllcustomer() {
//	  	return cusService.getAll();
//	 	}

//to delete the child data in order		
	@DeleteMapping(value = "/deleteorder/{id}")
	public String deleteCustomer(@PathVariable("id") UUID id) {
		cusService.deleteorder(id);
		return "deleted";
	}

//to delete the child data in orderitem		
	@DeleteMapping(value = "/deletecus/{id}")
	public String deleteCus(@PathVariable("id") UUID id) {
		cusService.deletecus(id);
		return "deleted";
	}
	
	
//namedQuery
	@RequestMapping(value = "/cus", method = RequestMethod.GET) 
	public List<Cus> getAllCus(@RequestParam (value = "code",required = false) String code) {
		return cusService.getAllCus(code);
	}

//namedQuery
	@RequestMapping(value = "/cus/{id}") 
	public List<Cus> getCusBId(@PathVariable("id") UUID cusId) {
		return cusService.getcusById(cusId);
	}
}
