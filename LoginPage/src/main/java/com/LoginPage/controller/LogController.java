package com.LoginPage.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LoginPage.Dto.SignRequestDto;
import com.LoginPage.common.APIResponse;
import com.LoginPage.entity.User;
import com.LoginPage.entity.UserRole;
import com.LoginPage.service.LoginService;

@RestController
@RequestMapping("/api")
public class LogController {

	@Autowired
	private LoginService loginService;

	@PostMapping(value = "/userrole")
	public ResponseEntity<APIResponse> createUserRole(@RequestBody UserRole userRole) {
		loginService.createUserRole(userRole);
		APIResponse apiResponse = new APIResponse();
		apiResponse.setData("UserRole created successfully");
		apiResponse.setTimestamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.OK.value()).body(apiResponse);
	}

	@PostMapping(value = "/user/create")
	public ResponseEntity<APIResponse> createUser(@RequestBody SignRequestDto signRequestDto) {
		User validUsername = loginService.findByUsername(signRequestDto.getUserName());
		User validmobileNo = loginService.findByMobileNo(signRequestDto.getMobileNo());

		if (validUsername != null) {
			APIResponse apiResponse = new APIResponse();
			apiResponse.setData("Duplicate username can't accepted");
			apiResponse.setTimestamp(LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(apiResponse);
		}

		if (validmobileNo != null) {
			APIResponse apiResponse = new APIResponse();
			apiResponse.setData("Duplicate mobileno can't accepted");
			apiResponse.setTimestamp(LocalDateTime.now());
		}

		APIResponse response = loginService.createUser(signRequestDto);
		APIResponse apiResponse = new APIResponse();
		apiResponse.setData("User created successfully");
		apiResponse.setTimestamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.OK.value()).body(apiResponse);
	}

	@GetMapping(value = "/user/getall")
	public ResponseEntity<APIResponse> getAllUsers() {
		List<User> user = loginService.getAllUsers();
		APIResponse apiResponse = new APIResponse();
		apiResponse.setData(user);
		apiResponse.setMessage("User fetched successfully");
		apiResponse.setTimestamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.OK.value()).body(apiResponse);
	}

	@GetMapping(value = "/user/get/{id}")
	public ResponseEntity<APIResponse> getuserById(@PathVariable UUID id) {
		List<User> user = loginService.getuserById(id);
		APIResponse apiResponse = new APIResponse();
		apiResponse.setData(user);
		apiResponse.setMessage("User getById fetched sucessfully");
		apiResponse.setTimestamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.OK.value()).body(apiResponse);
	}

	@PutMapping(value = "/user/update")
	public ResponseEntity<APIResponse> updateUser(@RequestBody User user) {
		User userExists = loginService.findUserById(user.getId());
		if (userExists == null) {
			APIResponse apiResponse = new APIResponse();
			apiResponse.setData("User Not Found");
			apiResponse.setTimestamp(LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(apiResponse);
		} else {
			userExists.setId(user.getId());
			userExists.setUserRoleId(user.getUserRoleId());
			userExists.setFirstName(user.getFirstName());
			userExists.setLastName(user.getLastName());
			userExists.setUserName(user.getUserName());
			userExists.setEmail(user.getEmail());
			userExists.setMobileNo(user.getMobileNo());
			userExists.setPassword(user.getPassword());
			loginService.updateUser(userExists);

			APIResponse apiResponse = new APIResponse();
			apiResponse.setData("User updated successfully");
			apiResponse.setTimestamp(LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.OK.value()).body(apiResponse);
		}
	}

	@DeleteMapping(value = "/user/delete/{id}")
	public ResponseEntity<APIResponse> deleteUser(@PathVariable UUID id) {
		User deleteuser = loginService.deleteUserById(id);
		if (deleteuser == null) {
			APIResponse apiResponse = new APIResponse();
			apiResponse.setData("User Not Found");
			apiResponse.setTimestamp(LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(apiResponse);
		}
		loginService.deleteuserById(id);
		APIResponse apiResponse = new APIResponse();
		apiResponse.setData("User deleted successfully");
		apiResponse.setTimestamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.OK.value()).body(apiResponse);
	}
}
