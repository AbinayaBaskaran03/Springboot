package com.ebrain.springboot.demo.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ebrain.springboot.demo.demo.dto.User;
import com.ebrain.springboot.demo.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
	private UserRepository userRepository;
    
    
	public void save(User user) {
		
		userRepository.save(user);
	}
	public List<User> getAllUser() {
		return userRepository.getAllUser();
	}
}
