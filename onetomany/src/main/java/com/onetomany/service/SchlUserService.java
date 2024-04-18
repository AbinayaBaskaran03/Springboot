package com.onetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomany.entity.PasswordUtil;
import com.onetomany.entity.School;
import com.onetomany.entity.User;
import com.onetomany.repository.SchlRepository;
import com.onetomany.repository.UserRepository;

@Service
public class SchlUserService {
	@Autowired
	public SchlRepository schlRepository;
	@Autowired
	public UserRepository userRepository;

	public User SchlttoUser(School school) {
		
		School SchoolObj = schlRepository.save(school);
		
		String phonenum = PasswordUtil.getPassword(school.getPhone());
		
		User userObj = new User();
		
		userObj.setRefId(SchoolObj.getId());
		userObj.setUserName(SchoolObj.getStuName());
		userObj.setPassword(phonenum);
		userObj.setUserDob(SchoolObj.getStuDob());
		userObj.setStatus(SchoolObj.getStatus());
		
		return userRepository.save(userObj);
	}

}
