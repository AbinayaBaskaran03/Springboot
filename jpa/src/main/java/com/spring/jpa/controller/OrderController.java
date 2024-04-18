package com.spring.jpa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.jpa.entity.CusOrder;
import com.spring.jpa.service.CustomerService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/create")
	public CusOrder createcustomer(@RequestBody CusOrder order) {
		customerService.saveOrder(order);
		return order;
	}
	
      @GetMapping(value = "/get")
     	public  List<CusOrder> getAllcustomer() {
     	return customerService.getAllOrder();
     	}
}
