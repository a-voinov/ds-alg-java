package com.me.arrays.sort.practice;

import com.me.arrays.UnorderedArray;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Array with selection sort implemented
 */
public class SelectionSortArray extends UnorderedArray {
    public SelectionSortArray(int size) {
        super(size);
    }

    public void sort(){
        //TODO
    }

    public static void main(String[] args){
        int size = 100;
        Random random = new Random();
        SelectionSortArray array = new SelectionSortArray(size);
        for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(size) + 1);
        }
        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
        array.display();

        long elapsedTime = measureEnd - measureStart;
        System.out.println("array sorted with selection sort in " + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " seconds");
    }
}
