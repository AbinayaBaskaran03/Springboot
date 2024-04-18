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
@Table(name = "tb_book2_abi")
public class Book2 {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;

	@Column(name = "book2_id")
	@Type(type = "uuid-char")
	private UUID book2Id;

	@Column(name = "book2_title")
	private String book2Title;

	@Column(name = "book2_price")
	private String book2Price;
	
	@Column(name = "book2_pswd")
	private String book2Pswd;
}
