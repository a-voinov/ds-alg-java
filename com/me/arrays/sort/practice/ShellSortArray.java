package com.me.arrays.sort.practice;

import com.me.arrays.UnorderedArray;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Array with Shell sort implemented
 */
public class ShellSortArray extends UnorderedArray {
    public ShellSortArray(int size) {
        super(size);
    }

    public void sort(){
        //TODO
    }

    public static void main(String[] args){
        int size = 5_000_000;
        Random random = new Random();
        ShellSortArray array = new ShellSortArray(size);
        for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(size) + 1);
        }
        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
        //array.display();

        long elapsedTime = measureEnd  -  measureStart;
        System.out.println("array sorted with Shell sort in " + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " seconds");

    }
}
