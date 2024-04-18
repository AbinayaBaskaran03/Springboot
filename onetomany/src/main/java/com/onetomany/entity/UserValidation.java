package com.onetomany.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_user_abi")
public class UserValidation {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(name = "user_name")
	 private String userName;	
	
	@Column(name = "first_name")	 
	private String firstName;
	
	@Column(name = "last_name")	 
	private String lastName;
	
	@Column(name = "date")	 
	private Date date = new Date();
	
	@Column(name = "email")	 
	 private String email;
	
	@Column(name = "mobileno")	 
	 private String mobileNo;
	
	@Column(name = "address")	 
	 private String address;
	
	@Column(name = "pincode")	 
	 private String pinCode;

	 

}
