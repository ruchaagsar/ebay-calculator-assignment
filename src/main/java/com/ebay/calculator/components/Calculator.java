package com.ebay.calculator.components;

import com.ebay.calculator.dto.Operation;
import com.ebay.calculator.strategy.OperationStrategy;
import com.ebay.calculator.service.StrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class Calculator {

	@Autowired
	private StrategyFactory strategyFactory;

	public Number calculate(Operation operation, Number num1, Number num2) {
		log.info("received operation: {}, num1: {}, num2: {}", operation, num1, num2);
		OperationStrategy strategy = strategyFactory.getStrategy(operation);

		if (strategy == null) {
			throw new UnsupportedOperationException("Operation not supported: " + operation);
		}

		log.info("executing strategy: {}", strategy.getClass().getSimpleName());
		return strategy.execute(num1, num2);
	}
}
