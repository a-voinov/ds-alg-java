package com.me.arrays.sort.impl.quick;

import com.me.arrays.UnorderedArray;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *  Array with QuickSort implemented. First element from subarray was chosen as a pivot.
 */
public class QuickSortArrayFirst extends UnorderedArray {

    public QuickSortArrayFirst(int size) {
        super(size);
    }

    private void quicksort(int left, int right){
        if (right - left < 2){
            return;
        }
        int pivotIndex = partition(left, right);
        quicksort(left, pivotIndex);
        quicksort(pivotIndex + 1, right);
    }

    private int partition(int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;

        while (i < j){
            while ( i < j && arr[--j] >= pivot) { }
            if (i < j) {arr[i] = arr[j];}

            while ( i < j && arr[++i] <= pivot) { }
            if (i < j) {arr[j] = arr[i];}
        }
        arr[j] = pivot;
        return j;
    }


    public void sort(){
        quicksort(0, elementsCount);
    }

    public static void main(String[] args){
        int size = 10_000_000;
        Random random = new Random();
        QuickSortArrayFirst array = new QuickSortArrayFirst(size);
       // array.arr = new int[] { 20, 35, -15, 7, 55, 1, -22 };
       // array.elementsCount = size;
        for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(size) + 1);
        }
        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
        //array.display();

        long elapsedTime = measureEnd  -  measureStart;
        System.out.println("array sorted with Quick sort in " + TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " MILLISECONDS");

    }
}
