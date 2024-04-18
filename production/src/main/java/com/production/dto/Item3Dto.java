package com.production.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Item3Dto {
	private UUID id;
	private String item3Name;
	private Integer item3Qty;
	private Double eachitemRate;
	private String status;

}
