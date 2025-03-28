package com.ebay.calculator.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DivideOperation implements OperationStrategy {
	@Override
	public Number execute(Number num1, Number num2) {
		if (num2.doubleValue() == 0.0) {
			log.error("DoubleDivideOperation: Division by zero is not allowed");
			throw new ArithmeticException("Division by zero is not allowed");
		}

		if (Double.isNaN(num1.doubleValue()) || Double.isNaN(num2.doubleValue())) {
			log.error("DoubleDivideOperation: NaN encountered in division");
			throw new ArithmeticException("Invalid operation: NaN encountered");
		}

		if (Double.isInfinite(num1.doubleValue()) || Double.isInfinite(num2.doubleValue())) {
			log.warn("DoubleDivideOperation: Infinity encountered in division, result may be infinite");
			throw new ArithmeticException("Invalid operation: infinity encountered");
		}

		double result = num1.doubleValue() / num2.doubleValue();

		if (result == 0.0 && num1.doubleValue() != 0.0) {
			log.warn("DoubleDivideOperation: Result is very close to zero, possible underflow");
		}

		return result;
	}
}