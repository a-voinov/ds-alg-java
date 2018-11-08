package com.me.arrays.search.impl;

import com.me.arrays.OrderedArray;

public class BinarySearch extends OrderedArray {
    public BinarySearch(int size) {
        super(size);
    }

    /**
     * binary search in ordered array
     */
    public int search(int value) {
        int left = 0;
        int right = arr.length - 1;
        while (true){
            int center = (left + right) / 2;
            if (arr[center] == value) return center; else
            if (left > right) return -1; else
            if (arr[center] > value){
                right = center - 1;
            } else {
                left = center + 1;
            }
        }
    }

    public static void main(String[] args){
        BinarySearch orderedArray = new BinarySearch(5);
        orderedArray.insert(-50);
        orderedArray.insert(20);
        orderedArray.insert(70);
        orderedArray.insert(10);
        orderedArray.insert(-40);
        orderedArray.insert(22);
        orderedArray.insert(9);
        orderedArray.display();
        System.out.println(orderedArray.search(9));
    }
}
