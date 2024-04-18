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
@Table(name = "tb_trans_kab")
public class Transaction {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(name = "product_id")
	@Type(type = "uuid-char")
	private UUID productId;
	
	@Column(name = "trans_date")
	private Date transDate;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "status")
	private String status;
}
