package com.revature.assignments;

import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        // Comment & uncomment as you see fit
        Functional f = (x, y) -> "Hello "  + x + " " + y;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        System.out.println(f.operation(scanner.next(), scanner.next()));
    }
}
