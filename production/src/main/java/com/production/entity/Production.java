package com.production.entity;

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
@Table(name = "tb_pro_kab")
public class Production {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(name = "manu_date")
	private Date manuDate;
	
	@Column(name = "exp_date")
	private Date expDate;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "status")
	private String status;

	

	
	
	
	
	
	

}
