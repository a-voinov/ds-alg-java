package com.me.arrays.sort.impl;

import com.me.arrays.UnorderedArray;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Array with Radix sort implemented
 */
public class RadixSortArray extends UnorderedArray {
    public RadixSortArray(int size) {
        super(size);
    }

    public void sort(int radix, int width){
        for (int i = 0; i < width; i++) {
            radixSingleSort(i, radix);
        }
    }

    private void radixSingleSort(int position, int radix) {
        int[] countArray = new int[radix];
        for (int value : arr) {
            countArray[getDigit(position, value, radix)]++;
        }
        for (int j = 1; j < radix; j++){
            countArray[j] += countArray[j - 1];
        }
        int[] temp = new int[elementsCount];
        for (int tempIndex = elementsCount - 1; tempIndex >= 0; tempIndex--){
            temp[--countArray[getDigit(position, arr[tempIndex], radix)]] =
                    arr[tempIndex];
        }
        System.arraycopy(temp, 0, arr, 0, temp.length);
    }

    private int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

    public static void main(String[] args) {
        int size = 6;
        Random random = new Random();
        RadixSortArray array = new RadixSortArray(size);
        array.arr = new int[] { 4725, 4586, 1330, 8792, 1594, 5729 };
        array.elementsCount = size;
       /* for (int i = 0; i < size; i++) {
            //numbers in array should be from 1 to 10
            array.insert(random.nextInt(10) + 1);
        }*/
        //array.display();
        //System.out.println("----------------------------------------");
        long measureStart = System.nanoTime();
        array.sort(10, 4);
        long measureEnd = System.nanoTime();
        array.display();

        long elapsedTime = measureEnd  -  measureStart;
        System.out.println("array sorted with Radix sort in " + TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " MILLISECONDS");
    }
}
