package com.me.array.sort.impl;

import com.me.array.UnorderedArray;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Array with Counting sort implemented
 */
public class CountingSortArray extends UnorderedArray {
    public CountingSortArray(int size) {
        super(size);
    }

    public void sort(){
        //numbers in array should be from 1 to 10
        int[] counting = new int[10];
        for (int i : arr){
            counting[i-1]++;
        }
        int j = 0;
        for (int i = 1; i <= 10; i++) {
            while (counting[i - 1] > 0) {
                arr[j++] = i;
                counting[i - 1]--;
            }
        }
    }

    public static void main(String[] args) {
        int size = 10_000_000;
        Random random = new Random();
        CountingSortArray array = new CountingSortArray(size);
        for (int i = 0; i < size; i++) {
            //numbers in array should be from 1 to 10
            array.insert(random.nextInt(10) + 1);
        }
        //array.display();
        //System.out.println("----------------------------------------");
        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
       // array.display();

        long elapsedTime = measureEnd  -  measureStart;
        System.out.println("array sorted with counting sort in " + TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " MILLISECONDS");
    }
}
