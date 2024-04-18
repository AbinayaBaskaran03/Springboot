package com.ebrain.springboot.demo.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ebrain.springboot.demo.demo.dto.Student;

@RestController
@RequestMapping("/message")
public class StudentController {
	
	@GetMapping(value="/get")
	public String getMessage() {
		return "Get mesage has been send ";
	}
	@PostMapping("/post")
	public Student posttMessage(@RequestBody Student request) {	
		System.out.println("Name:"+request.getName());
		request.setMessage("Message has been sent");
	return request ;
	}
	
}
