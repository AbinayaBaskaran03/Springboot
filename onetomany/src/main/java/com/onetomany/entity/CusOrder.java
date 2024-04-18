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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_cus_order_abi")
public class CusOrder {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;

	@Column(name = "order_no")
	private String order_no;

	@Column(name = "order_date")
	private Date order_date = new Date();

	@Column(name = "no_of_items")
	private String no_of_items;

	@Column(name = "order_sub_total")
	private String order_sub_total;

	@Column(name = "order_discount")
	private String order_discount;

	@Column(name = "order_total_amount")
	private String order_total_amount;

	@Column(name = "payment_type")
	private String payment_type;

	@Column(name = "delivery_date")
	private Date delivery_date;

	@Column(name = "status")
	private String status;

	@Column(name = "created_date")
	private Date created_date = new Date();

	@Column(name = "created_by")
	private String created_by;

	@Column(name = "modified_date")
	private Date modified_date;

	@Column(name = "modified_by")
	private String modified_by;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false, insertable = false, updatable = false)
	private Cus cus;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
	private List<CusOrderItem> cusOrderItem;

}
