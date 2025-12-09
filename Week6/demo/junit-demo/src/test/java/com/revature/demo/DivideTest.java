package com.revature.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class DivideTest {
    private static Calculator calculator = null;

    @BeforeAll
    public static void setupClass() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Normal Division Test")
    public void testDivide() {
        double n1 = 10.0;
        double n2 = 4.0;
        double expectedResult = 2.5;
        double actualResult = calculator.divide(n1, n2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Divide by Zero Test")
    public void testDivideByZero() {
        double n1 = 100.0;
        double n2 = 0.0;

        IllegalArgumentException actualResult = assertThrows(IllegalArgumentException.class, () -> {calculator.divide(n1, n2);});
    }
}
