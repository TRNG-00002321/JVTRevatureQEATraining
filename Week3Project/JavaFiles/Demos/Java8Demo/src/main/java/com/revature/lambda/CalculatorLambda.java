package com.revature.lambda;

public class CalculatorLambda {
    public static void main(String[] args) {
        printResult(2, 3, (x, y) -> x + y);
        printResult(3, 2, (a, b) -> a - b);
    }

    public static void printResult(int a, int b, Calculator func) {
        // Perform operation, print result
        int result = func.operation(a, b);
        System.out.println(result);
    }
}
