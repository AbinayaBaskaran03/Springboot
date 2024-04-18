package com.LoginPage.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LoginPage.entity.UserRole;
@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, UUID>{

}
