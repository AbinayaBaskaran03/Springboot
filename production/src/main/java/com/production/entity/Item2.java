package com.production.entity;

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
@Table(name = "tb_item2_kab")
public class Item2 {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;

	
	@Column(name = "item2_name")
	private String item2Name;
	
	@Column(name = "item2_qty")
	private Integer item2Qty;
	
	@Column(name = "eachitem_rate")
	private Double eachitemRate;
	
	@Column(name = "status")
	private String status;
	

}
