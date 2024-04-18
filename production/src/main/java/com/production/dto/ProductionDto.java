package com.production.dto;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductionDto {
	private UUID id;
	
	private Date manuDate;
	private Date expDate;
	private Integer quantity;
	private String status;
	
	private Item1Dto item1dto;
	private Item2Dto item2dto;
	private Item3Dto item3dto;
	private TransactionDto transactionDto;

	
}
