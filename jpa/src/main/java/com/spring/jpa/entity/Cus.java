package com.spring.jpa.entity;
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
@Table(name = "tb_cus_abi")
public class Cus {
	
	@Id                                                                                       //used to specify the id as primarykey
	@GeneratedValue(generator = "UUID")                                                       //
	@GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")              //
	@Column	(name="id",updatable = false,nullable = false)	
	@Type(type = "uuid-char")                                                                  //specific id n must said about the uuid
    private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "contact_person_name")
	private String contact_person_name;

	@Column(name = "contact_person_phone")
	private String contact_person_phone;

	@Column(name = "status")
	private String status;

	@Column(name = "create_date")
	private Date create_date = new Date();

	@Column(name = "created_by")
	private String created_by;

	@Column(name = "modified_date")
	private Date modified_date= new Date();

	@Column(name = "modified_by")
	private String modified_by;

}
