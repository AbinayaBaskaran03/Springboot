package com.spring.jpa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.jpa.entity.CusOrderItem;
import com.spring.jpa.service.CustomerService;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/create")
	public CusOrderItem createcustomer(@RequestBody CusOrderItem orderitem) {
		customerService.saveOrderItem(orderitem);
		return orderitem;
	}
	
      @GetMapping(value = "/get")
     	public  List<CusOrderItem> getAllcustomer() {
     	return customerService.getAllOrderItem();
     	}
}
