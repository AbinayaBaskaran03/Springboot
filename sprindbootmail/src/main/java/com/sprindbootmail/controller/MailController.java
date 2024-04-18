package com.sprindbootmail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprindbootmail.entity.Mail;
import com.sprindbootmail.service.MailService;
@RestController
@RequestMapping("/mail")
public class MailController {

	@Autowired
	private MailService mailService;
	
	@PostMapping(value = "/sendmail")
	public String sendMail(@RequestBody Mail mail) {
		mailService.saveCus(mail);
		
		return "Mail sent succesfully";
	}
}
//https://github.com/AbinayaBaskaran1005/mail.git