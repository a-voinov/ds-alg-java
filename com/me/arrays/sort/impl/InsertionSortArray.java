package com.me.arrays.sort.impl;

import com.me.arrays.UnorderedArray;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Array with insertion sort implemented
 */
public class InsertionSortArray extends UnorderedArray {
    public InsertionSortArray(int size) {
        super(size);
    }

    public void sort(){
        for(int outer = 1; outer < elementsCount; outer++) {
            int save = arr[outer];
            int inner = outer;
            while (inner > 0 && arr[inner - 1] >= save){
                arr[inner] = arr[inner-1];
                inner--;
            }
            arr[inner] = save;
        }
    }

    public static void main(String[] args){
        int size = 300_000;
        Random random = new Random();
        InsertionSortArray array = new InsertionSortArray(size);
        for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(size) + 1);
        }
        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
        //array.display();

        long elapsedTime = measureEnd  -  measureStart;
        System.out.println("array sorted with insertion sort in " + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " seconds");

    }
}
