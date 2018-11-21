package com.me.array.sort.impl;

import com.me.array.UnorderedArray;

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
        for(int outer = 0; outer < elementsCount - 1; outer++){
            int min = outer;
            for (int inner = outer + 1; inner < elementsCount; inner++){
                if (arr[inner] < arr[min]){
                    min = inner;
                }
            }
            int temp = arr[outer];
            arr[outer] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args){
        int size = 300_000;
        Random random = new Random();
        SelectionSortArray array = new SelectionSortArray(size);
        for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(size) + 1);
        }
        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
        //array.display();

        long elapsedTime = measureEnd - measureStart;
        System.out.println("array sorted with selection sort in " + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " seconds");
    }
}
