package com.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onetomany.entity.Author;
import com.onetomany.service.AuthorBookService;

@RestController
@RequestMapping("/author")
public class AuthorBookController {
	
	@Autowired
	private AuthorBookService authorBookService;
	
	@PostMapping(value = "/book")
	public String createAuthor(@RequestBody Author author) {
		authorBookService.saveAuthor(author);
		return "Author and Book saved";
	}
	
	

}
