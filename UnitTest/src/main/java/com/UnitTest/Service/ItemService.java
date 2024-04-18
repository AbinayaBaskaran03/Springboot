package com.UnitTest.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.UnitTest.Entity.Item;

@Service
public class ItemService {
	 public List<Item> getAllItems() {
	        // Logic to retrieve items from a database or other source
	        // For simplicity, we'll return a hardcoded list in this example
	        return Arrays.asList(
	                new Item("item1", 10),
	                new Item("item2", 20),
	                new Item("item3", 30)
	        );
	    }
}
