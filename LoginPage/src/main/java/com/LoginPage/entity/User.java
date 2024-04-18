package com.LoginPage.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.LoginPage.common.JpaAuditing;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User  extends JpaAuditing implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(name = "role_id")
	@Type(type = "uuid-char")
	private UUID userRoleId;
	
	@Column(name = "user_name")
	private String userName;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "user_role")
	private String userRole;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "Password")
	private String password;
	
	
	
	

	
}
