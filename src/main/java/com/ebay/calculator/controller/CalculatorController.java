package com.ebay.calculator.controller;

import lombok.extern.slf4j.Slf4j;
import com.ebay.calculator.dto.OperationRequest;
import com.ebay.calculator.dto.ChainRequest;
import com.ebay.calculator.dto.Response;
import com.ebay.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/v1/calculator")
public class CalculatorController {

	private final CalculatorService calculatorService;

	@Autowired
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@PostMapping("/calculate")
	public Response calculate(@Valid @RequestBody OperationRequest operationRequest) {
		log.info("CalculatorController: received calculate request={}", operationRequest);
		Number result = calculatorService.calculate(operationRequest);
		return Response.builder().code("200").message("Calculation successful").data(result).build();
	}

	@PostMapping("/chain")
	public Response chainOperations(@Valid @RequestBody ChainRequest chainRequest) {
		log.info("CalculatorController: received chain request={}", chainRequest);

		log.info("CalculatorController: starting chained calculator");
		Number result = calculatorService.calculateChain(chainRequest);
		return Response.builder().code("200").message("Chained calculation successful").data(result).build();
	}
}