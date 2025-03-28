package com.ebay.calculator.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivideOperationTest {
    private DivideOperation divideOperation = new DivideOperation();

    @Test
    public void testDivideOperation() {
        assertEquals(2.0, divideOperation.execute(6.0, 3.0));
        assertEquals(-1.0, divideOperation.execute(-2.0, 2.0));
        assertThrows(ArithmeticException.class, () -> divideOperation.execute(1.0, 0.0));
    }
}
