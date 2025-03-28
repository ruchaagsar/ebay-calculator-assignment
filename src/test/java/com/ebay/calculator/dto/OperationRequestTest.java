package com.ebay.calculator.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationRequestTest {

    @Test
    public void testObjectCreationWithGettersAndSetters() {
        OperationRequest operationRequest = new OperationRequest();
        operationRequest.setOp(Operation.ADD);
        operationRequest.setNum1(1);
        operationRequest.setNum2(2);

        assertEquals(1, operationRequest.getNum1());
        assertEquals(2, operationRequest.getNum2());
        assertEquals(Operation.ADD, operationRequest.getOp());
    }
}
