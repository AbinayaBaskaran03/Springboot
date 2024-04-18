package com.Login.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Login.Common.ApiResponse;
import com.Login.Dto.LoginRequestDto;
import com.Login.Dto.SignUpRequestDto;
import com.Login.Entity.UserEntity;
import com.Login.Repo.LoginRepo;
import com.Login.Utils.JwtUtils;

@Service
public class LoginService {

	@Autowired
	private LoginRepo loginRepo;

	@Autowired
	private JwtUtils jwtUtils;

	public ApiResponse signUp(SignUpRequestDto signUpRequestDto) {

		ApiResponse apiResponse = new ApiResponse();

//dto to entity	
		UserEntity UserEntity = new UserEntity();
		UserEntity.setName(signUpRequestDto.getName());
		UserEntity.setEmailId(signUpRequestDto.getEmailId());
		UserEntity.setIsActive(Boolean.TRUE);
		UserEntity.setMobileNo(signUpRequestDto.getMobileNo());
		UserEntity.setPassword(signUpRequestDto.getPassword());

		loginRepo.save(UserEntity);
		apiResponse.setData(UserEntity);

		return apiResponse;
	}

	public ApiResponse login(LoginRequestDto loginRequestDto) {
		ApiResponse apiResponse = new ApiResponse();
//verify		
		UserEntity user = loginRepo.findOneByMobileNoAndPassword(loginRequestDto.getMobileNo(),
				loginRequestDto.getPassword());

//response
		if (user == null) {
			apiResponse.setData("User login failed");
			return apiResponse;
		}
// generate jwt
		String token = jwtUtils.generateJwt(user);
		
		Map<String, Object>  data = new HashMap();
		data.put("user_token", token);
				
		apiResponse.setData(data);

		return apiResponse;
	}

}
