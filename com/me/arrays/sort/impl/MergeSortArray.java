package com.me.arrays.sort.impl;

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
        int i = left; int j = mid; int tempIndex = 0;
        int[] temp = new int[arr.length];
        while (i < mid && j < right)
            temp[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        //example of merge
        //[{33, 36}, {34, 35, 37}] src
        //[33, 34, 35] temp
        //[33, 36, 34, 36, 37] res (src) step 1
        //[33, 34, 35, 36, 37] res (src) step 2
        System.arraycopy(arr, i, arr, left + tempIndex, mid - i); // step 1
        System.arraycopy(temp, 0, arr, left, tempIndex); // step 2
    }

    private void split(int left, int right){
        if (right - left < 2) return;
        int mid = (right + left) / 2;
        split(left, mid);
        split(mid, right);
        merge(left, mid, right);
    }

    public void sort(){
        split( 0, elementsCount);
    }

    public static void main(String[] args){
        int size = 100_000;
        Random random = new Random();
        MergeSortArray array = new MergeSortArray(size);
       // array.arr = new int[] { 20, 35, -15, 7, 55, 1, -22 };
       // array.elementsCount = size;
        for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(size) + 1);
        }
        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
        array.display();

        long elapsedTime = measureEnd  -  measureStart;
        System.out.println("array sorted with Merge sort in " + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " seconds");

    }
}
