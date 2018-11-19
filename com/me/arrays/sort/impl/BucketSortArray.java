package com.me.arrays.sort.impl;

import com.me.arrays.UnorderedArray;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Array with bucket sort implemented for two number integers
 */
public class BucketSortArray extends UnorderedArray {

    public BucketSortArray(int size) {
        super(size);
    }

    private void sort(){
        List<Integer>[] buckets = new LinkedList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        //scattering
        for (int i = 0; i < arr.length; i++) {
            buckets[hash(arr[i])].add(arr[i]);
        }
        //sorting
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (Integer block : buckets[i]) {
                arr[j++] = block;
            }
        }
    }

    private int hash(int value){
        return value / 10;
    }

    public static void main(String[] args){
        int size = 300_000;
        Random random = new Random();
        BucketSortArray array = new BucketSortArray(size);
        /*
        for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(size) + 1);
        }*/
        array.arr = new int[]{54, 46, 83, 66, 95, 92, 43};
        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
        array.display();

        long elapsedTime = measureEnd  -  measureStart;
        System.out.println("array sorted with bucket sort in " + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " seconds");

    }
}
