package com.UnitTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UnitTest.Entity.Item;
import com.UnitTest.Service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	
	    @Autowired
	    private ItemService itemService;

	    @GetMapping
	    public ResponseEntity<List<Item>> getAllItems() {
	        List<Item> items = itemService.getAllItems();
	        return new ResponseEntity<>(items, HttpStatus.OK);
	    }

}
