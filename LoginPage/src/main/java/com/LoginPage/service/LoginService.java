package com.LoginPage.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoginPage.Dto.SignRequestDto;
import com.LoginPage.common.APIResponse;
import com.LoginPage.common.Status;
import com.LoginPage.entity.User;
import com.LoginPage.entity.UserRole;
import com.LoginPage.repo.Loginrepository;
import com.LoginPage.repo.UserRoleRepo;

@Service
public class LoginService {

	@Autowired
	private Loginrepository loginrepository;

	@Autowired
	private UserRoleRepo userRoleRepo;

	static final DateFormat DB_DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public APIResponse createUserRole(UserRole userRole) {
		APIResponse APIResponse = new APIResponse();
		userRoleRepo.save(userRole);
		return APIResponse;
	}

	public APIResponse createUser(SignRequestDto signRequestDto) {
		APIResponse apiResponse = new APIResponse();
		User user = new User();
		user.setUserRoleId(signRequestDto.getUserRoleId());
		user.setUserName(signRequestDto.getUserName());
		user.setFirstName(signRequestDto.getFirstName());
		user.setLastName(signRequestDto.getLastName());
		user.setEmail(signRequestDto.getEmail());
		user.setMobileNo(signRequestDto.getMobileNo());
		user.setPassword(signRequestDto.getPassword());
		user.setCreatedOn(LocalDateTime.now());
		user.setStatus(Status.Active);
		Optional<UserRole> role = userRoleRepo.findById(signRequestDto.getUserRoleId());
		if (role.isPresent()) {
			UserRole userrole = role.get();
			user.setCreatedBy(userrole.getUserRole());
			user.setUserRole(userrole.getUserRole());
		}
		loginrepository.save(user);
		return apiResponse;
	}

	public List<User> getAllUsers() {
		return loginrepository.findAll();
	}

	public List<User> getuserById(UUID id) {
		return loginrepository.findAllById(Collections.singletonList(id));
	}

	public User updateUser(User user) {

		user.setModifiedOn(LocalDateTime.now());
		Optional<UserRole> role = userRoleRepo.findById(user.getUserRoleId());
		if (role.isPresent()) {
			UserRole userrole = role.get();
			user.setModifiedBy(userrole.getUserRole());
			user.setUserRole(userrole.getUserRole());
		}
		return loginrepository.save(user);
	}

	public User findUserById(UUID id) {
		return loginrepository.findById(id).orElse(null);
	}

	public User deleteUserById(UUID id) {
		return loginrepository.findById(id).orElse(null);
	}

	public User findByUsername(String userName) {
		return loginrepository.findByUserName(userName);
	}

//	public User findByphoneNo(String mobileNo) {
//		return loginrepository.findByPhoneNo(mobileNo);
//	}

	public void deleteuserById(UUID id) {
		loginrepository.deleteById(id);
	}

	public User findByMobileNo(String mobileNo) {
		return loginrepository.findByMobileNo(mobileNo);
	}

}
