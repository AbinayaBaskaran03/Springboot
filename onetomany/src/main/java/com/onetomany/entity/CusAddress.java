package com.onetomany.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_cus_address_abi")
public class CusAddress {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;
     
	@Column(name = "address_type")
	private String address_type;

	@Column(name = "address_line1")
	private String address_line1;

	@Column(name = "address_line2")
	private String address_line2;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	
	@Column(name = "country")
	private String country;

	@Column(name = "postal_code")
	private String postal_code;

		
	
	@ManyToOne
	@JoinColumn(name = "customer_id",nullable = false,insertable = false,updatable = false)
	private Cus cus;

}
