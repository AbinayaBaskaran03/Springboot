package com.onetomany.entity;

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
@Table(name = "tb_user_rk_abi")
public class User   {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(name = "ref_id")
	@Type(type = "uuid-char")
	private UUID refId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_dob")
	private String userDob;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "status")
	private String status;
	
}
