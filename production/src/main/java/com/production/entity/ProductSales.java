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
@Table(name = "tb_productsales_kab")
public class ProductSales {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(name = "palkova_rate")
	private Double palkovaRate;
	
	@Column(name = "rasagulla_rate")
	private Double rasagullaRate;
	
	@Column(name = "rasamalai_rate")
	private Double rasamalaiRate;
	
	@Column(name = "status")
	private String status;

}
