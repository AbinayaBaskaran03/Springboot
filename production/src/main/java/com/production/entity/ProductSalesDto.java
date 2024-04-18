package com.production.entity;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProductSalesDto {

	private UUID id;
	private Double palkovaRate;
	private Double rasagullaRate;
	private Double rasamalaiRate;
	private String status;

}
