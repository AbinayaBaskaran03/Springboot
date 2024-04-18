package com.onetomany.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_address_abi")
public class Address {
	
	@Id                                                                                       
	@GeneratedValue(generator = "UUID")                                                       
	@GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")              
	@Column	(name="id",updatable = false,nullable = false)
	@Type(type = "uuid-char")                                                                  
    private UUID id;
	
	@Column(name = "first_name")
    private String firstName;
	
	@Column(name = "last_name")
    private String lastName;

	@Column(name = "date_of_birth")
    private Date dateOfBirth;
	
	@Column(name = "email_id")
    private String emailId;
	
	@Column(name = "phone_no")
    private String phoneNo;
	
	@Column(name = "city")
    private String city;
	
	@Column(name = "state")
    private String state;
	
	@Column(name = "country")
    private String country;
	
	 @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 @JoinColumn(name = "customer_id",referencedColumnName = "id",nullable = false)

	 private List<Address1> address1 ;

	
	
	
}
