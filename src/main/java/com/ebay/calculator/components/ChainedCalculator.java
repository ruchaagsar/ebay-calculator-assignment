package com.ebay.calculator.components;

import com.ebay.calculator.dto.Operation;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ChainedCalculator {
	private final Calculator calculator;
	private Number currentValue;

	public ChainedCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public ChainedCalculator start(Number initialValue) {
		this.currentValue = initialValue;
		return this;
	}

	public ChainedCalculator apply(Operation operation, Number operand) {
		log.info("ChainedCalculator: applying operation: {}, operand: {}", operation, operand);
		currentValue = calculator.calculate(operation, currentValue, operand);
		return this;
	}

	public Number getResult() {
		return currentValue;
	}
}