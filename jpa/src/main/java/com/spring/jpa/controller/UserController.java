package com.spring.jpa.controller;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.jpa.entity.User;
import com.spring.jpa.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @PostMapping(value = "/create")
	public  User createUser(@RequestBody User user) {
	user.setcreatedDate(LocalDateTime.now());
	userService.saveUser(user);
	return user;
	}
    
    @GetMapping(value = "/get")
   	public  List<User> getAllUser() {
   	return userService.getAll();
   	}
    
////ALTERQUERY
//      @PostMapping(value = "/create")
//    public  ResponseEntity<User> createUser(@RequestBody User user) {
//	user.setcreatedDate(LocalDateTime.now());
//	userService.saveUser(user);
//	return ResponseEntity.ok(user);
//	}
//	 @GetMapping(value = "/get")
//   	public ResponseEntity <List<User>> getAllUser() {
//   	return ResponseEntity.ok(userService.getAll());
//   	}
    
  
    
	}


