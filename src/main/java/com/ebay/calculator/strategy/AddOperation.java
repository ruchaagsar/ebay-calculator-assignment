package com.ebay.calculator.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddOperation implements OperationStrategy {

	@Override
	public Number execute(Number num1, Number num2) {
		// Convert both numbers to double for the operation
		double a = num1.doubleValue();
		double b = num2.doubleValue();
		double result = a + b;

		// Check for overflow
		if (Double.isInfinite(result) || Double.isNaN(result)) {
			log.error("DoubleAddOperation: Double overflow or invalid result");
			throw new ArithmeticException("Double overflow or invalid result");
		}

		return result;
	}
}
