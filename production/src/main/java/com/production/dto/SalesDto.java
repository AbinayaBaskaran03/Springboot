package com.production.dto;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesDto {
	
	private UUID id;
	private UUID productId;

	private Integer cusId;
	private Date salesDate;

	private Integer palkova;
	private Integer rasagulla;
	private Integer rasamalai;
	
	private Integer totItems;
	private Double palkovaRate;
	private Double rasagullaRate;
	private Double rasamalaiRate;
	private Double totAmount;
	private String status;
	
   private TransactionDto transactionDto;


}
