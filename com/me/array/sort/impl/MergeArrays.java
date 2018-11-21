package com.me.array.sort.impl;

/**
 * Example of merging two array.
 * (Mental preparation to the merge sort)
 */
public class MergeArrays {

    public static void main(String[] args) {
        int[] arrayA = {23, 47, 81, 95};
        int[] arrayB = {7, 14, 39, 55, 62, 74};
        int[] arrayC = new int[10];
        merge(arrayA, arrayB, arrayC);
        display(arrayC, 10);
    }

    public static void merge( int[] arrayA,
                              int[] arrayB,
                              int[] arrayC ) {
        int a=0, b=0, c=0;
        while (a < arrayA.length && b < arrayB.length){
            arrayC[c++] = arrayA[a] < arrayB[b] ? arrayA[a++] : arrayB[b++];
        }
        while (a < arrayA.length)
            arrayC[c++] = arrayA[a++];
        while (b < arrayB.length)
            arrayC[b++] = arrayB[b++];
    }

    public static void display(int[] theArray, int size) {
        for(int j=0; j<size; j++)
            System.out.print(theArray[j] + " ");
        System.out.println();
    }

}
