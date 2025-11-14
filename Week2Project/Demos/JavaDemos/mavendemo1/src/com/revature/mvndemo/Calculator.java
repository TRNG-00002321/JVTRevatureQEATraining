package com.revature.mvndemo;

public class Calculator {
    public int add(int ...args) {
        int result = 0;
        for (int arg : args) {
            result += arg;
        }
        return result;
    }

    public int subtract(int num, int ...args) {
        int result = num;
        for (int arg : args) {
            result -= arg;
        }
        return result;
    }

    public int multiply(int ...args){
        int result = 1;
        for (int arg : args) {
            result *= arg;
        }
        return result;
    }

    public int divide(int num, int ...args) {
        int result = num;
        for (int arg : args) {
            result /= arg;
        }
        return result;
    }
}
