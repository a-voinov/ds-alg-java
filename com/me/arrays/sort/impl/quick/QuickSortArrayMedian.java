package com.me.arrays.sort.impl.quick;

import com.me.arrays.UnorderedArray;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Array with QuickSort implemented. Pivot is being chosen as median from 3 dots
 */
public class QuickSortArrayMedian extends UnorderedArray {

    public QuickSortArrayMedian(int size) {
        super(size);
    }

    private void swap(int indexA, int indexB){
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    private void manualSort(int left, int right){
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (arr[left] > arr[right])
                swap(left, right);
        } else {
            if (arr[left] > arr[right - 1])
                swap(left, right - 1);
            if (arr[left] > arr[right])
                swap(left, right);
            if (arr[right - 1] > arr[right])
                swap(right - 1, right);
        }
    }

    private int median(int left, int right){
        int center = (left + right) / 2;

        if (arr[left] > arr[center])
            swap(left, center);

        if (arr[left] > arr[right])
            swap(left, right);

        if (arr[center] > arr[right])
            swap(center, right);

        swap(center, right - 1);
        return arr[right - 1];
    }

    private int partition(int left, int right, int pivot){
        int i = left;
        int j = right - 1;
        while(true)
        {
            while( arr[++i] < pivot ) {}
            while( arr[--j] > pivot ) {}
            if(i >= j)
                break;
            else
                swap(i, j);
        }
        swap(i, right-1);
        return i;
    }

    private void quicksort(int left, int right){
        int size = right - left + 1;
        if (size <= 3)
            manualSort(left, right);
        else {
            int median = median(left, right);
            int partition = partition( left, right, median);
            quicksort(left, partition - 1);
            quicksort( partition + 1, right);
        }
    }

    public void sort(){
        quicksort(0, elementsCount - 1);
    }

    public static void main(String[] args){
        int size = 10_000_000;
        Random random = new Random();
        QuickSortArrayMedian array = new QuickSortArrayMedian(size);
        //array.arr = new int[] { 20, 35, -15, 7, 55, 1, -22 };
       /* array.arr = new int[] { 16, 32, 0, -5, 3, 7, -1 };
        array.elementsCount = size;*/
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
