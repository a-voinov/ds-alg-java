package com.me.recursion.practice;

/**
 * Tower Of Hanoi puzzle solution
 */
public class TowerOfHanoi {

    static int step = 0;

    public static void towers(int topN, char from, char inter, char to){
        step++;
        if (topN == 1) {
            System.out.printf("Move %d from %s to %s", topN, from, to);
            System.out.println();
        }
        else {
            towers(topN - 1, from, to, inter);
            System.out.printf("Move %d from %s to %s", topN, from, to);
            System.out.println();
            towers(topN - 1, inter, from, to);
        }
    }

    public static void main(String[] args){
        towers(4, 'A', 'B', 'C');
        System.out.println();
        System.out.printf("Steps: %d", step);
    }
}
