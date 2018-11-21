package com.me.array.sort.impl;

import com.me.array.UnorderedArray;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Array with bubble sort implemented
 */
public class BubbleSortArray extends UnorderedArray {

    public BubbleSortArray(int size) {
        super(size);
    }

    public void sort(){
        for(int outer = elementsCount-1; outer > 0; outer--)
            for(int inner = 0; inner < outer; inner++ )
                if (arr[inner] > arr[inner+1])
                {   //swap
                    int temp = arr[inner];
                    arr[inner] = arr[inner + 1];
                    arr[inner + 1] = temp;
                }
    }

    public static void main(String[] args) {
        int size = 300_000;
        Random random = new Random();
        BubbleSortArray array = new BubbleSortArray(size);
        for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(size) + 1);
        }
        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
        //array.display();

        long elapsedTime = measureEnd  -  measureStart;
        System.out.println("array sorted with bubble sort in " + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " seconds");
    }
}
