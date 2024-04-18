package com.Login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Login.Common.ApiResponse;
import com.Login.Dto.LoginRequestDto;
import com.Login.Dto.SignUpRequestDto;
import com.Login.Service.LoginService;

@RestController
@RequestMapping("/Login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping(value = "/signup")
	public ResponseEntity<ApiResponse> createsignUp(@RequestBody SignUpRequestDto signUpRequestDto) {
		ApiResponse apiResponse = loginService.signUp(signUpRequestDto);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<ApiResponse> createlogIn(@RequestBody LoginRequestDto loginRequestDto) {
		ApiResponse apiResponse = loginService.login(loginRequestDto);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
}
