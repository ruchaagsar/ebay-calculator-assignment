package com.ebay.calculator.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidParameterExceptionTest {

    @Test
    public void testExceptionCreation(){
        InvalidParameterException invalidParameterException = new InvalidParameterException("InvalidParameterException test");
        assertEquals(invalidParameterException.getMessage(), "InvalidParameterException test");

        Throwable cause = new Exception();
        invalidParameterException = new InvalidParameterException("InvalidParameterException test", cause);
        assertEquals("InvalidParameterException test", invalidParameterException.getMessage());
        assertEquals(cause, invalidParameterException.getCause());

        invalidParameterException = new InvalidParameterException(cause);
        assertEquals(cause, invalidParameterException.getCause());
    }
}
