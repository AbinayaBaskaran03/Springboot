package com.LoginPage.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LoginPage.entity.User;

@Repository
public interface Loginrepository extends JpaRepository<User, UUID> {

	User save(UUID id);

	User findAllById(UUID id);

	User findByUserName(String userName);


	//User findByPhoneNo(String mobileNo);

	User findByMobileNo(String mobileNo);

}
