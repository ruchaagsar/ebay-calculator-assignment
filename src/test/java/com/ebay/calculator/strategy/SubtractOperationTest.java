package com.ebay.calculator.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubtractOperationTest {

    private SubtractOperation subtractOperation = new SubtractOperation();

    @Test
    public void testSubtractOperation() {
        assertEquals(2.0, subtractOperation.execute(5.0, 3.0));
        assertEquals(-4.0, subtractOperation.execute(-2.0, 2.0));
        assertThrows(ArithmeticException.class, () -> subtractOperation.execute(Double.NaN, 0.0));
        assertThrows(ArithmeticException.class, () -> subtractOperation.execute(Double.POSITIVE_INFINITY, 0.0));
    }
}
