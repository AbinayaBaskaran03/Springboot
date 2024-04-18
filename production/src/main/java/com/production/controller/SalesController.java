package com.production.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.production.dto.SalesDto;
import com.production.entity.Sales;
import com.production.service.SalesService;

@RestController
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	private SalesService salesService;

	@PostMapping(value = "/transaction")
	public String create(@RequestBody SalesDto salesDto) {
		salesService.createSalesandTrans(salesDto);
		return "sales and transaction created";
	}

//getAllSales
	@GetMapping(value = "/get")
	public List<Sales> getAllsales() {
		return salesService.getAllSales();
	}

// getbyCusId
	@GetMapping(value = "/getbycusid/{cus_id}")
	public List<Sales> getbyCusId(@PathVariable("cus_id") Integer cusId) {
		return salesService.getBycusId(cusId);
	}

//getbySalesdate	
	@GetMapping(value = "/getbydate")
	public List<Sales> findBySalesDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date salesDate) {
		return salesService.findBydate(salesDate);
	}

}
