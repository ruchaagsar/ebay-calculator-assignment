package com.ebay.calculator.service;

import com.ebay.calculator.dto.ChainOperationRequest;
import com.ebay.calculator.dto.ChainRequest;
import com.ebay.calculator.dto.Operation;
import com.ebay.calculator.dto.OperationRequest;
import com.ebay.calculator.exceptions.InvalidParameterException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationServiceTest {
    private ValidationService validationService = new ValidationService();

    @Test
    public void testValidateCalculateRequest() {
        OperationRequest operationRequest = new OperationRequest();
        operationRequest.setOp(Operation.DIVIDE);
        operationRequest.setNum1(1);
        operationRequest.setNum2(2);

        validationService.validateCalculateRequest(operationRequest);
        operationRequest.setNum2(0.0);
        assertThrows(InvalidParameterException.class, () -> validationService.validateCalculateRequest(operationRequest));
    }


    @Test
    public void testValidateChainRequest() {
        ChainRequest chainRequest = new ChainRequest();
        chainRequest.setInitialValue(1.0);

        ChainOperationRequest chainOperationRequest = new ChainOperationRequest();
        chainOperationRequest.setOp(Operation.DIVIDE);
        chainOperationRequest.setNum(1.0);
        chainRequest.setOperations(Arrays.asList(chainOperationRequest));

        validationService.validateChainRequest(chainRequest);
        chainOperationRequest.setNum(0.0);
        assertThrows(InvalidParameterException.class, () -> validationService.validateChainRequest(chainRequest));
    }
}
