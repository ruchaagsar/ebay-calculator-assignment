package com.ebay.calculator.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ChainOperationRequest {
	@NotNull
	private Operation op;
	@NotNull
	private Number num;
}
