package com.me.arrays;

/**
 * Expandable array
 */
public class DynamicArray extends Array {

    private int initialSize;

    public DynamicArray(){
        // length of arr is 10 by default
        super(10);
        initialSize = 10;
    }

    public DynamicArray(int initialSize){
        super(initialSize);
        this.initialSize = initialSize;
    }

    @Override
    public void insert(int index, int value){
        if (index < 0) throw new ArrayIndexOutOfBoundsException();
        if (index > initialSize){
            arr = expandArray(index + 1);
        }
        arr[index] = value;
    }

    private int[] expandArray(int newLength){
        //return Arrays.copyOf(arr, newLength);
        int[] arrCopy = new int[newLength];
        for (int i = 0; i < initialSize; i++) {
            arrCopy[i] = arr[i];
        }
        return arrCopy;
    }

}
