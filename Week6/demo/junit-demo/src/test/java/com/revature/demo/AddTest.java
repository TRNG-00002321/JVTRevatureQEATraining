package com.revature.demo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddTest {

    public Calculator calculator = null;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("This is the Setup method .... BeforeEach");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("This is the Teardown method .... AfterEach");
    }

    @BeforeAll
    public static void setupClass() {
        System.out.println("BeforeAll method is called.");
    }

    @AfterAll
    public static void teardownClass() {
        System.out.println("AfterAll method is called.");
    }

    @Test
    @DisplayName("Testing Add Method... Positive")
    @Order(1)
    void testAdd() {
        // System.out.println("Test Add Positive");

        // Arrange
        Calculator calculator = new Calculator();
        int n1 = 10;
        int n2 = 12;
        int expectedResult = 22;
        int actualResult;

        // Act
        actualResult = calculator.add(n1, n2);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Testing Add Method... Negative")
    // @Disabled
    @Order(2)
    void testAddNegative() {
        // System.out.println("Test Add Negative");

        // Arrange
        int n1 = -10;
        int n2 = -12;
        int expectedResult = -22;
        int actualResult;

        // Act
        actualResult = calculator.add(n1, n2);

        // Assert
        assertEquals(expectedResult, actualResult);
    }
}
