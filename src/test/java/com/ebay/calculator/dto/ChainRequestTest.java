package com.ebay.calculator.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChainRequestTest {
    @Test
    public void testObjectCreationWithGettersAndSetters() {
        ChainRequest chainRequest = new ChainRequest();
        chainRequest.setInitialValue(100);

        ChainOperationRequest chainOperationRequest = new ChainOperationRequest();
        chainOperationRequest.setOp(Operation.ADD);
        chainOperationRequest.setNum(1.0);

        List<ChainOperationRequest> chainOperationRequestList = new ArrayList<>();
        chainOperationRequestList.add(chainOperationRequest);

        assertEquals(100, chainRequest.getInitialValue());
        assertEquals(chainOperationRequestList, chainRequest.getOperations());
        assertEquals(1, chainRequest.getOperations().size());
    }
}
