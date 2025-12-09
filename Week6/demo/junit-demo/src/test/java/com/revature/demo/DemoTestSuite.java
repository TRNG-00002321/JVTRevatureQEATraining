package com.revature.demo;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;

@Suite
@SelectClasses({
        AddTest.class,
        MultiplyTest.class,
        DivideTest.class,
        CalculatorParameterizedTest.class
})
public class DemoTestSuite {
}
