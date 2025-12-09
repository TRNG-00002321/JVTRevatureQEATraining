package com.revature.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
// import org.junit.jupiter.params.provider.CsvFileSources;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorParameterizedTest {
    Calculator calculator = null;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest(name="{0} + {1} = {2}")
    @CsvSource({
            "1, 2, 3",
            "2, 2, 4",
            "-1, -5, -6",
            "4, -12, -8",
            "1, -10, -9"
    })
    @Order(1)
    public void testAdd(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculator.add(a, b));
    }

    @ParameterizedTest(name = "Adding {0} and {1} is {2}")
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    // @CsvFileSources() ces
    @Order(2)
    public void testAddAgain(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculator.add(a, b));
    }

    @ParameterizedTest(name = "Adding {0} and {1} is {2} using method")
    @MethodSource("testDataMethod")
    @Order(2)
    public void testAddThird(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculator.add(a, b));
    }

    static Stream<Arguments> testDataMethod() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(-2, 4, 2),
                Arguments.of(4, 5, 9)
                );
    }
}
