package com.revature.jen;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @Test
    @DisplayName("Should add two positive numbers")
    void testAddPositiveNumbers() {
        Assertions.assertEquals(8, calculator.add(5, 3));
    }

    @Test
    @DisplayName("Should add positive and negative numbers")
    void testAddMixedNumbers() {
        Assertions.assertEquals(2, calculator.add(5, -3));
    }

    @Test
    @DisplayName("Should add two negative numbers")
    void testAddNegativeNumbers() {
        Assertions.assertEquals(-8, calculator.add(-5, -3));
    }

    @Test
    @DisplayName("Should return same number when adding zero")
    void testAddZero() {
        Assertions.assertEquals(5, calculator.add(5, 0));
        Assertions.assertEquals(5, calculator.add(0, 5));
    }

    @ParameterizedTest
    @CsvSource({
            // Add 2 positive numbers
            "3, 5, 8",
            // Add 1 positive and 1 negative number
            "5, -2, 3",
            // Add 2 negative numbers
            "-3, -4, -7",
            // Add 2 zeros
            "0, 0, 0"
    })
    @DisplayName("Add two ints with various sign combos")
    void testAdd_normal(int num1, int num2, int expected) {
        Assertions.assertEquals(expected, calculator.add(num1, num2));
    }
}
