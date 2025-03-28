package com.ebay.calculator.components;

import com.ebay.calculator.dto.Operation;
import com.ebay.calculator.service.StrategyFactory;
import com.ebay.calculator.strategy.AddOperation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

    @Mock
    private StrategyFactory strategyFactory;

    @InjectMocks
    private Calculator calculator;

    @Test
    public void testCalculate() {
        when(strategyFactory.getStrategy(eq(Operation.ADD))).thenReturn(new AddOperation());
        assertEquals(3.0, calculator.calculate(Operation.ADD, 1,2));
    }

    @Test
    public void testCalculate_throwsException() {
        when(strategyFactory.getStrategy(eq(Operation.ADD))).thenReturn(null);
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(Operation.ADD, 1,2));
    }
}
