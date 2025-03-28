package com.ebay.calculator.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChainOperationRequestTest {

    @Test
    public void testObjectCreationWithGettersAndSetters() {
        ChainOperationRequest chainOperationRequest = new ChainOperationRequest();
        chainOperationRequest.setOp(Operation.ADD);
        chainOperationRequest.setNum(1.0);

        assertEquals(1.0, chainOperationRequest.getNum());
        assertEquals(Operation.ADD, chainOperationRequest.getOp());
    }
}
