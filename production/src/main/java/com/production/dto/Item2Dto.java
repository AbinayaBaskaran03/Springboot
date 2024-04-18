package com.production.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Item2Dto {
	private UUID id;
	private String item2Name;
	private Integer item2Qty;
	private Double eachitemRate;
	private String status;

}
