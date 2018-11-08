package com.me.arrays.sort.practice;

import com.me.arrays.UnorderedArray;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *  Array with QuickSort implemented
 */
public class QuickSortArray extends UnorderedArray {

    public QuickSortArray(int size) {
        super(size);
    }

    private void quicksort(int left, int right){
        //TODO
    }

    private int partition(int left, int right) {
        //TODO
        throw new NotImplementedException();
    }

    public void sort(){
        quicksort(0, elementsCount);
    }

    public static void main(String[] args){
        int size = 7;
        Random random = new Random();
        QuickSortArray array = new QuickSortArray(size);
        //array.arr = new int[] { 20, 35, -15, 7, 55, 1, -22 };
        array.arr = new int[] { 16, 32, 0, -5, 3, 7, -1 };
        array.elementsCount = size;
        /*for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(size) + 1);
        }*/
        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
        array.display();

        long elapsedTime = measureEnd  -  measureStart;
        System.out.println("array sorted with Quick sort in " + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " seconds");

    }
}
