package com.me.recursion;

public class Factorial {

    public static long factorialLoop(int n){
        long factorial = 1;
        while (n > 1){
            factorial *= n--;
        }
        return factorial;
    }

    public static long factorial(int n){
        if (n == 1){
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args){
        System.out.println(factorial(8));
    }
}
