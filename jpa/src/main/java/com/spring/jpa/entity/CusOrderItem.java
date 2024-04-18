package com.spring.jpa.entity;

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
@Table(name="tb_cus_orderitem_abi")
public class CusOrderItem {
	
	@Id                                                                                     
	@GeneratedValue(generator = "UUID")                                                      
  	@GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")             
 	@Column	(name="id",updatable = false,nullable = false)
	@Type(type = "uuid-char") 
	private UUID id;
	
	@Column(name="order_id") 
	@Type(type = "uuid-char") 
    private UUID order_id;
    
	@Column(name="item_name") 
	private String item_name;

	@Column(name="item_sku") 
	private String item_sku;

	@Column(name="item_rate") 
	private String item_rate;

	@Column(name="ordered_qty") 
	private String ordered_qty;

	@Column(name="order_total") 
	private String order_total;

    
}
