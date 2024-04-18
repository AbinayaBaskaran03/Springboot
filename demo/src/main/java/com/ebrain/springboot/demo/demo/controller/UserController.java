package com.ebrain.springboot.demo.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ebrain.springboot.demo.demo.dto.User;
import com.ebrain.springboot.demo.demo.service.UserService;
import com.ebrain.springboot.demo.demo.dto.GenericResponse;


@RestController
@RequestMapping("/user")
public class UserController {
	
   @Autowired
   private UserService userService;
	
    @PostMapping(value="/create")
	public GenericResponse<User> createUser(@RequestBody User user) {
    userService.save(user);
    	
   GenericResponse<User> response = new GenericResponse<User>();
   response.setStatus("Active");
   response.setMessage("postmessage sent");
   response.setDatalist(null);
   response.setData(null);
   return response;

		
	}
    @GetMapping(value="/get")
  	public  GenericResponse<User> getAllUser() {
    List<User> user = userService.getAllUser();
    	
    GenericResponse<User> response = new GenericResponse<User>();
    response.setStatus("Active");
    response.setMessage("getmessage sent");
    response.setDatalist(null);
    response.setData(null);
    return response;

  	} 
}
