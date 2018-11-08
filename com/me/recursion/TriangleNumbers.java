package com.me.recursion;

public class TriangleNumbers {

    public static int triangleLoop(int n){
        int triangle = 1;
        while (n > 1){
            triangle += n--;
        }
        return triangle;
    }

    public static int triangle(int n){
        if (n == 1){
            return 1;
        }
        return n + triangle(n-1);
    }

    public static void main(String args[]){
        System.out.println(triangle(1000));
    }
}
