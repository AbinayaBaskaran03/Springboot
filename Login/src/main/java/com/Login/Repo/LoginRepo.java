package com.Login.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Login.Entity.UserEntity;

public interface LoginRepo extends JpaRepository<UserEntity, UUID>{

	UserEntity findOneByMobileNoAndPassword(String mobileNo, String password);

}
