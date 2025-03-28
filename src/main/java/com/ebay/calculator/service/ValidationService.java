package com.ebay.calculator.service;

import java.util.List;

import com.ebay.calculator.dto.Operation;
import com.ebay.calculator.exceptions.InvalidParameterException;
import lombok.extern.slf4j.Slf4j;
import com.ebay.calculator.dto.OperationRequest;
import com.ebay.calculator.dto.ChainRequest;
import com.ebay.calculator.dto.ChainOperationRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ValidationService {

	public void validateCalculateRequest(OperationRequest operationRequest) {
		Number num1 = operationRequest.getNum1();
		Number num2 = operationRequest.getNum2();

		if(operationRequest.getOp() == Operation.DIVIDE)
			validateInputs(num1, num2);
	}

	public void validateChainRequest(ChainRequest chainRequest) {
		List<ChainOperationRequest> operations = chainRequest.getOperations();
		validateInputs(operations);
	}


	private void validateInputs(Number num1, Number num2) {
		if (num2.doubleValue() == 0.0) {
			log.error("Invalid input: Divisor cannot be 0");
			throw new InvalidParameterException("Invalid input: Divisor cannot be 0");
		}
	}

	private void validateInputs(List<ChainOperationRequest> operations) {
		for (ChainOperationRequest chainOperationRequest : operations) {
			if (chainOperationRequest.getOp() == Operation.DIVIDE && chainOperationRequest.getNum().doubleValue() == 0.0) {
				log.error("Invalid operation request: Operation and number cannot be null");
				throw new InvalidParameterException("Invalid operation request: Operation and number cannot be null");
			}
		}
	}
}
