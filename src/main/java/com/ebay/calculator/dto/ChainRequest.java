package com.ebay.calculator.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChainRequest {
	@JsonProperty("initial_value")
	@NotNull
	private Number initialValue;

	@Valid
	@NotNull
	@NotEmpty
	List<ChainOperationRequest> operations;
}
