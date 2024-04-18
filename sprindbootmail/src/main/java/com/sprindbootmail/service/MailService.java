package com.sprindbootmail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sprindbootmail.entity.Mail;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void saveCus(Mail mail) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mail.getRecipient());
		message.setText(mail.getText());
		message.setSubject(mail.getSubject());

		javaMailSender.send(message);
}
}
