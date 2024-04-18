package com.production.dto;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {

	private UUID id;
	private UUID productId;
	private Date transDate;
	private Integer quantity;
	private String status;

}
