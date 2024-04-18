package com.production.entity;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductuionTransfer {
	private String productName;
	private Date manuDate;
	private Date expDate;
	private String receivedQty;
	private String status;

	private UUID productId;
	private String itemName;
	private String itemQty;
	private String pergramRate;
	private String status1;
	
	

	
}
