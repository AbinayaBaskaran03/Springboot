package com.production.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Item1Dto {
	private UUID id;
	private String item1Name;
	private Integer item1Qty;
	private Double eachitemRate;
	private String status;

}
