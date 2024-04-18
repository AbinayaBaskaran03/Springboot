package com.Login.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.Login.Common.UserRole;

@Entity
@Table(name = "tb_user_Entity")
public class UserEntity {

	@Id
	@GeneratedValue
	private UUID id;

	private String name;

	private String emailId;

	private String mobileNo;

	private String userType = UserRole.USER_ROLE.ADMIN;

	private String password;

	private Boolean isActive = true;

	private LocalDateTime loginAt;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getLoginAt() {
		return loginAt;
	}

	public void setLoginAt(LocalDateTime loginAt) {
		this.loginAt = loginAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
	public void onSave() {
		LocalDateTime currentDateTime = LocalDateTime.now();

		this.createdAt = currentDateTime;
		this.updatedAt = currentDateTime;
		this.loginAt = currentDateTime;

	}
	@PostPersist
	public void onUpdate() {
		LocalDateTime currentDateTime = LocalDateTime.now();

		this.updatedAt = currentDateTime;
		this.loginAt = currentDateTime;
	}
}
