package com.ebay.calculator.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperationRequest {
	@NotNull
	private Operation op;
	@NotNull
	private Number num1;
	@NotNull
	private Number num2;
}
