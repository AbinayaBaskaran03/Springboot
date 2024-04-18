package com.production.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.production.dto.ProductionDto;
import com.production.service.ProductionService;

@RestController
@RequestMapping("/production/trans")
public class ProductionController {

	@Autowired
	public ProductionService productionService;

	@PostMapping(value = "/product")
	public String createproduct(@RequestBody ProductionDto productionDto) {
		productionService.saveProduction(productionDto);
		return "product and production created";  
	    
	 
	}

}
