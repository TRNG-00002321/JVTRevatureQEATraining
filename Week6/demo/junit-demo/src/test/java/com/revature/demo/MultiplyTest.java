package com.revature.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class MultiplyTest {
    private static Calculator calculator = null;

    @BeforeAll
    public static void setupClass() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Multiply Ints Test ... Positive x Positive")
    public void testMultiplyInts1() {
        int n1 = 5;
        int n2 = 3;
        int expectedResult = 15;
        int actualResult = calculator.multiply(n1, n2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Multiply Doubles Test ... Positive x Positive")
    public void testMultiplyDoubles1() {
        double n1 = 5.0;
        double n2 = 6.0;
        double expectedResult = 30.0;
        double actualResult = calculator.multiply(n1, n2);
        assertEquals(expectedResult, actualResult);
    }
}
