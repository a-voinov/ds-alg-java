package com.me.array.sort.practice;

import com.me.array.UnorderedArray;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InsertionSortArray extends UnorderedArray {
    public InsertionSortArray(int size) {
        super(size);
    }

    public void sort(){
        //TODO
    }

    public static void main(String[] args){
        int size = 10000;
        Random random = new Random();
        InsertionSortArray array = new InsertionSortArray(size);
        for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(size) + 1);
        }
        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
        array.display();

        long elapsedTime = measureEnd  -  measureStart;
        System.out.println("array sorted with insertion sort in " + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " seconds");

    }
}
