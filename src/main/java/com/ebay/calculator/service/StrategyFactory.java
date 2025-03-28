package com.ebay.calculator.service;

import java.util.HashMap;
import java.util.Map;

import com.ebay.calculator.strategy.*;
import lombok.extern.slf4j.Slf4j;
import com.ebay.calculator.dto.Operation;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StrategyFactory {
	private Map<Operation, OperationStrategy> opStrategyMap = new HashMap<>();
	public OperationStrategy getStrategy(Operation operation) {

		if (operation == Operation.ADD) {
			if(!opStrategyMap.containsKey(Operation.ADD)){
				opStrategyMap.put(Operation.ADD, new AddOperation());
			}
			return opStrategyMap.get(Operation.ADD);
		} else if (operation == Operation.SUBTRACT) {
			if(!opStrategyMap.containsKey(Operation.SUBTRACT)){
				opStrategyMap.put(Operation.SUBTRACT, new SubtractOperation());
			}
			return opStrategyMap.get(Operation.SUBTRACT);
		} else if (operation == Operation.MULTIPLY) {
			if(!opStrategyMap.containsKey(Operation.MULTIPLY)){
				opStrategyMap.put(Operation.MULTIPLY, new MultiplyOperation());
			}
			return opStrategyMap.get(Operation.MULTIPLY);
		} else if (operation == Operation.DIVIDE) {
			if(!opStrategyMap.containsKey(Operation.DIVIDE)){
				opStrategyMap.put(Operation.DIVIDE, new DivideOperation());
			}
			return opStrategyMap.get(Operation.DIVIDE);
		}
		throw new UnsupportedOperationException("Unsupported operation");
	}
}