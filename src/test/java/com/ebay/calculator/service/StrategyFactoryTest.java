package com.ebay.calculator.service;

import com.ebay.calculator.dto.Operation;
import com.ebay.calculator.strategy.OperationStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrategyFactoryTest {
    private StrategyFactory strategyFactory = new StrategyFactory();

    @Test
    public void testSingletonStrategies(){
        OperationStrategy addStrategy = strategyFactory.getStrategy(Operation.ADD);
        assertEquals(addStrategy, strategyFactory.getStrategy(Operation.ADD));

        OperationStrategy subtractStrategy = strategyFactory.getStrategy(Operation.SUBTRACT);
        assertEquals(subtractStrategy, strategyFactory.getStrategy(Operation.SUBTRACT));

        OperationStrategy multiplyStrategy = strategyFactory.getStrategy(Operation.MULTIPLY);
        assertEquals(multiplyStrategy, strategyFactory.getStrategy(Operation.MULTIPLY));

        OperationStrategy divideStrategy = strategyFactory.getStrategy(Operation.DIVIDE);
        assertEquals(divideStrategy, strategyFactory.getStrategy(Operation.DIVIDE));
    }
}
