package com.revature.lambda;

public class LambdaDemo {
    public static void main(String[] args) {
        Calculator c = (x, y) -> x + y;
        // Calculator c = (x, y) -> x - y;
        // Calculator c = (int x, int y) -> { return (x + y); };

        System.out.println(c.operation(2, 3));
        System.out.println(c.operation(5, 4));
    }
}
