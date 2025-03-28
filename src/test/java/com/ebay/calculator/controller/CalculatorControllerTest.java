package com.ebay.calculator.controller;

import com.ebay.calculator.dto.*;
import com.ebay.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {

    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculatorController calculatorController;

    @Test
    public void testCalculate(){
        OperationRequest operationRequest = new OperationRequest();
        operationRequest.setOp(Operation.ADD);
        operationRequest.setNum1(1);
        operationRequest.setNum2(2);

        when(calculatorService.calculate(operationRequest)).thenReturn(3.0);
        Response response = calculatorController.calculate(operationRequest);

        assertEquals("200", response.getCode());
        assertEquals(3.0, response.getData());
    }

    @Test
    public void testChainOperations(){
        ChainRequest chainRequest = new ChainRequest();
        chainRequest.setInitialValue(0.0);

        ChainOperationRequest chainOperationRequest = new ChainOperationRequest();
        chainOperationRequest.setOp(Operation.ADD);
        chainOperationRequest.setNum(1.0);

        chainRequest.setOperations(Arrays.asList(chainOperationRequest));

        when(calculatorService.calculateChain(chainRequest)).thenReturn(1.0);
        Response response = calculatorController.chainOperations(chainRequest);

        assertEquals("200", response.getCode());
        assertEquals(1.0, response.getData());
    }
}
