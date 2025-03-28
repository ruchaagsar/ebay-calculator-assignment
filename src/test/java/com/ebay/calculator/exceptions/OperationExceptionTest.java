package com.ebay.calculator.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationExceptionTest {

    @Test
    public void testExceptionCreation(){
        OperationException operationException = new OperationException("OperationException test");
        assertEquals(operationException.getMessage(), "OperationException test");

        Throwable cause = new Exception();
        operationException = new OperationException("OperationException test", cause);
        assertEquals("OperationException test", operationException.getMessage());
        assertEquals(cause, operationException.getCause());

        operationException = new OperationException(cause);
        assertEquals(cause, operationException.getCause());
    }
}
