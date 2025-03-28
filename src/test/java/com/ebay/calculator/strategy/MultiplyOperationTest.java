package com.ebay.calculator.strategy;

import org.junit.jupiter.api.Test;

import static java.lang.Double.POSITIVE_INFINITY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultiplyOperationTest {

    private MultiplyOperation multiplyOperation = new MultiplyOperation();

    @Test
    public void testMultiplyOperation() {
        assertEquals(6.0, multiplyOperation.execute(2.0, 3.0));
        assertEquals(-4.0, multiplyOperation.execute(-2.0, 2.0));
        assertEquals(3.0, multiplyOperation.execute(1.5, 2.0));
        assertThrows(ArithmeticException.class, () -> multiplyOperation.execute(POSITIVE_INFINITY, POSITIVE_INFINITY));
    }
}
