package com.me.arrays.sort.practice;

import com.me.arrays.UnorderedArray;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Array with Merge sort implemented
 */
public class MergeSortArray extends UnorderedArray {
    public MergeSortArray(int size) {
        super(size);
    }

    private void merge(int left, int mid, int right){
        //TODO
    }

    private void split(int left, int right){
        //TODO
    }

    public void sort(){
         split( 0, elementsCount);
    }

    public static void main(String[] args){
        int size = 7;
        Random random = new Random();
        MergeSortArray array = new MergeSortArray(size);
        array.arr = new int[] { 33, 38, 36, 34, 35, 37, 39 };
        array.elementsCount = size;
       /* for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(size) + 1);
        }*/
        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
        array.display();

        long elapsedTime = measureEnd  -  measureStart;
        System.out.println("array sorted with Merge sort in " + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " seconds");

    }
}
