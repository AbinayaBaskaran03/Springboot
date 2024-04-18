package com.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onetomany.entity.School;
import com.onetomany.service.SchlUserService;

@RestController
@RequestMapping("/school")
public class SchlUserController {

	@Autowired
	public SchlUserService schlUserService;

	@PostMapping(value = "/password")
	public String Datatransfer(@RequestBody School school) {
	 schlUserService.SchlttoUser(school);
		return "School and User Data created";
	}

}
