package com.spring.jpa.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="tb_user")
public class User {
	
	
	@Id                                                                                       //used to specify the id as primarykey
	@GeneratedValue(generator = "UUID")                                                       //
	@GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")              //
	@Column	(name="id",updatable = false,nullable = false)
	
	@Type(type = "uuid-char")                                                                  //specific id n must said about the uuid
    private UUID id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getemailId() {
		return emailId;
	}

	public void setemailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDateTime getcreatedDate() {
		return createdDate;
	}

	public void setcreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


}
