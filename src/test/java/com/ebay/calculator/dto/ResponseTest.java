package com.ebay.calculator.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseTest {
    @Test
    public void testObjectCreationWithGettersAndSetters() {
        Response response = Response.builder().code("200").message("Calculation successful").data(100).build();

        assertEquals("200", response.getCode());
        assertEquals("Calculation successful", response.getMessage());
        assertEquals(100, response.getData());
    }
}
