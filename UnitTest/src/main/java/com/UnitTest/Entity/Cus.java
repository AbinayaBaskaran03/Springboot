package com.UnitTest.Entity;

import java.time.LocalDate;
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
//@Entity
//@Table(name = "tb_cus_abi")
public class Cus {

//	@Id
//	@GeneratedValue(generator = "UUID")
//	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//	@Column(name = "id", updatable = false, nullable = false)
//	@Type(type = "uuid-char")
	private UUID id;

	//@Column(name = "name")
	private String name;

	//@Column(name = "code")
	private String code;

	//@Column(name = "email")
	private String email;

	//@Column(name = "phone")
	private String phone;

	//@Column(name = "contact_person_name")
	private String contact_person_name;

	//@Column(name = "contact_person_phone")
	private String contact_person_phone;

	//@Column(name = "status")
	private String status;

	//@Column(name = "create_date")
	private LocalDate create_date;

	//@Column(name = "created_by")
	private String created_by;

	//@Column(name = "modified_date")
	private LocalDate modified_date;

	//@Column(name = "modified_by")
	private String modified_by;

	public Cus(/*UUID id,*/ String name, String code, String email, String phone, String contact_person_name,
			String contact_person_phone, String status, LocalDate create_date, String created_by,
			LocalDate modified_date, String modified_by) {
		super();
		//this.id = id;
		this.name = name;
		this.code = code;
		this.email = email;
		this.phone = phone;
		this.contact_person_name = contact_person_name;
		this.contact_person_phone = contact_person_phone;
		this.status = status;
		this.create_date = create_date;
		this.created_by = created_by;
		this.modified_date = modified_date;
		this.modified_by = modified_by;
	}



	
	

	
	
}
