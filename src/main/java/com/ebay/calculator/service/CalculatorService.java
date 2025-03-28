package com.ebay.calculator.service;

import java.util.List;

import com.ebay.calculator.components.Calculator;
import com.ebay.calculator.components.ChainedCalculator;
import com.ebay.calculator.exceptions.OperationException;
import lombok.extern.slf4j.Slf4j;
import com.ebay.calculator.dto.Operation;
import com.ebay.calculator.dto.OperationRequest;
import com.ebay.calculator.dto.ChainRequest;
import com.ebay.calculator.dto.ChainOperationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalculatorService {

	private final Calculator calculator;
	private final ValidationService validationService;

	@Autowired
	public CalculatorService(Calculator calculator,
							 ValidationService validationService) {
		this.calculator = calculator;
		this.validationService = validationService;
	}

	public Number calculate(OperationRequest operationRequest) {
		validationService.validateCalculateRequest(operationRequest);
		Operation operation = operationRequest.getOp();

		Number result;
		Number num1 = null;
		Number num2 = null;
		try {
			num1 = operationRequest.getNum1();
			num2 = operationRequest.getNum2();
			result = calculator.calculate(operation, num1, num2);
		} catch (Exception e) {
			log.error("CalculatorService: Error during calculate: Operation={}, num1={}, num2={}", operation, num1,
					num2, e);
			throw new OperationException("Failed to execute calculation", e);
		}

		if (result == null) {
			log.error("CalculatorService: Error during calculate: Operation={}, num1={}, num2={}", operation, num1,
					num2);
			throw new OperationException("Failed to execute calculation");
		}
		return result;
	}


	public Number calculateChain(ChainRequest chainRequest) {
		validationService.validateChainRequest(chainRequest);
		Number initialValue = null;
		List<ChainOperationRequest> operations = null;

		ChainedCalculator chainedCalculator = new ChainedCalculator(calculator);
		try {
			initialValue = chainRequest.getInitialValue() != null ? chainRequest.getInitialValue() : 0;
			operations = chainRequest.getOperations();

			chainedCalculator.start(initialValue);
			for (ChainOperationRequest chainOperationRequest : operations) {
				Operation operation = chainOperationRequest.getOp();
				chainedCalculator.apply(operation, chainOperationRequest.getNum());
			}
			return chainedCalculator.getResult();
		} catch (Exception e) {
			log.error("CalculatorService: Error during calculateChain: initialValue={}, operations={}", initialValue,
					operations, e);
			throw new OperationException("Failed to execute chained calculation", e);
		}
	}
}