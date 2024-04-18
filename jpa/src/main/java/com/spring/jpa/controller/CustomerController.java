package com.spring.jpa.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.jpa.entity.Cus;
import com.spring.jpa.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
    @PostMapping(value = "/create")
	public  Cus createcustomer(@RequestBody Cus customer) {
    customerService.saveCustomer(customer);
    return customer;
   }
    
    @GetMapping(value = "/get")
  	public  List<Cus> getAllcustomer() {
  	return customerService.getAll();
 	}
    
 //Update   
    @PutMapping(value = "/update")
   	public  Cus updateCus(@RequestBody Cus customer) {
       customerService.updateCustomer(customer);
       return customer;
      }
    
//selectbyname
    @GetMapping(value = "/getbyname/{name}")
  	public  Cus getcusByname(@PathVariable("name") String Name ) {
  	return customerService.getByname(Name);
 	}
//Delete  
    @DeleteMapping(value = "/deletecus/{id}")
    public void deleteCustomer(@PathVariable UUID id ) {
    	customerService.deletecus(id);
    }  
}
