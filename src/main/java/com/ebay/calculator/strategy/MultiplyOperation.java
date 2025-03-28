package com.ebay.calculator.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultiplyOperation implements OperationStrategy {
	@Override
	public Number execute(Number num1, Number num2) {
		if (Double.isNaN(num1.doubleValue()) || Double.isNaN(num2.doubleValue())) {
			log.error("DoubleMultiplyOperation: NaN encountered in multiplication");
			throw new ArithmeticException("Invalid operation: NaN encountered");
		}

		if (Double.isInfinite(num1.doubleValue()) || Double.isInfinite(num2.doubleValue())) {
			log.warn("DoubleMultiplyOperation: Infinity encountered in multiplication, result may be infinite");
			throw new ArithmeticException("Invalid operation: infinity encountered");
		}

		double result = num1.doubleValue() * num2.doubleValue();
		if (Double.isInfinite(result)) {
			throw new ArithmeticException("DoubleMultiplyOperation: Double overflow in multiplication");
		}
		return result;
	}
}