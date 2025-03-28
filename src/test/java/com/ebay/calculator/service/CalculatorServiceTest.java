package com.ebay.calculator.service;

import com.ebay.calculator.components.Calculator;
import com.ebay.calculator.dto.ChainOperationRequest;
import com.ebay.calculator.dto.ChainRequest;
import com.ebay.calculator.dto.Operation;
import com.ebay.calculator.dto.OperationRequest;
import com.ebay.calculator.exceptions.OperationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @Mock
    private Calculator calculator;
    @Mock
    private ValidationService validationService;

    @InjectMocks
    private CalculatorService calculatorService;

    @Test
    public void testCalculate() {
        OperationRequest operationRequest = new OperationRequest();
        operationRequest.setOp(Operation.ADD);
        operationRequest.setNum1(1);
        operationRequest.setNum2(2);
        when(calculator.calculate(eq(Operation.ADD), eq(1), eq(2))).thenReturn(3.0);

        Number result = calculatorService.calculate(operationRequest);
        assertEquals(result, 3.0);
    }

    @Test
    public void testCalculate_throwsException() {
        OperationRequest operationRequest = new OperationRequest();
        operationRequest.setOp(Operation.ADD);
        operationRequest.setNum1(1);
        operationRequest.setNum2(2);
        when(calculator.calculate(eq(Operation.ADD), eq(1), eq(2))).thenThrow(new RuntimeException("Error occurred"));

        assertThrows(OperationException.class, ()->calculatorService.calculate(operationRequest));
    }

    @Test
    public void testCalculateChain() {
        ChainRequest chainRequest = new ChainRequest();
        chainRequest.setInitialValue(0.0);

        ChainOperationRequest chainOperationRequest = new ChainOperationRequest();
        chainOperationRequest.setOp(Operation.ADD);
        chainOperationRequest.setNum(1.0);

        chainRequest.setOperations(Arrays.asList(chainOperationRequest));

        when(calculator.calculate(eq(Operation.ADD), eq(0.0), eq(1.0))).thenReturn(1.0);

        Number result = calculatorService.calculateChain(chainRequest);
        assertEquals(result, 1.0);
    }
}
