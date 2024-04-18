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

@Entity
@Getter
@Setter
@Table(name = "tb_book3_abi")
public class Book3 {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;

	@Column(name = "book3_id")
	@Type(type = "uuid-char")
	private UUID book3Id;

	@Column(name = "book3_title")
	private String book3Title;

	@Column(name = "book3_price")
	private String book3Price;
	
	@Column(name = "book3_pswd")
	private String book3Pswd;
	
}

