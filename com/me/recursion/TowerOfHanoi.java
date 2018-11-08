package com.me.recursion;

/**
 * Tower Of Hanoi puzzle solution
 */
public class TowerOfHanoi {

    public static void towers(int topN, char from, char inter, char to){
        if (topN == 1){
            System.out.println("Disk 1 from " + from + " to "+ to);
        } else {
            towers(topN-1, from, to, inter); // from-->inter
            System.out.println("Disk " + topN +
                    " from " + from + " to "+ to);
            towers(topN-1, inter, from, to); // inter-->to
        }
    }

    public static void main(String[] args){
        towers(4, 'A', 'B', 'C');
    }
}
