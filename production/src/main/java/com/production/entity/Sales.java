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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_sales_kab")
public class Sales {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;

	@Column(name = "product_id",nullable = false)
	@Type(type = "uuid-char")
	private UUID productId;
	
	@Column(name = "cus_id",nullable = false)
	private Integer cusId;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/mm/dd")
	@Column(name = "sales_date")
	private Date salesDate ;
	
	@Column(name = "palkova")
	private Integer palkova;
	
	@Column(name = "rasagulla")
	private Integer rasagulla;
	
	@Column(name = "rasamalai")
	private Integer rasamalai;
	
	@Column(name = "tot_items")
	private Integer totItems;
	
	@Column(name = "palkova_rate")
	private Double palkovaRate;
	
	@Column(name = "rasagulla_rate")
	private Double rasagullaRate;
	
	@Column(name = "rasamalai_rate")
	private Double rasamalaiRate;
	
	@Column(name = "tot_amount")
	private Double totAmount;
	
	@Column(name = "status")
	private String status;
	
	
}
