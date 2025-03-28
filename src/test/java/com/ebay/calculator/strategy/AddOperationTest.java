package com.ebay.calculator.strategy;

import org.junit.jupiter.api.Test;

import static java.lang.Double.POSITIVE_INFINITY;
import static org.junit.jupiter.api.Assertions.*;

public class AddOperationTest {
    private AddOperation addOperation = new AddOperation();

    @Test
    public void testAddOperation() {
        assertEquals(5.0, addOperation.execute(2, 3));
        assertEquals(0.0, addOperation.execute(-2.0, 2.0));
        assertThrows(ArithmeticException.class, () -> addOperation.execute(Double.NaN, 0.0));
        assertThrows(ArithmeticException.class, () -> addOperation.execute(POSITIVE_INFINITY, POSITIVE_INFINITY));
    }
}
