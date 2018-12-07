package com.me.array.search.practice;

import com.me.array.OrderedArray;

public class BinarySearch extends OrderedArray {
    public BinarySearch(int size) {
        super(size);
    }

    /**
     * binary search in ordered array
     */
    public int search(int value) {
        //TODO
        return -1;
    }

    public static void main(String[] args){
        BinarySearch orderedArray = new BinarySearch(7);
        orderedArray.insert(-50);
        orderedArray.insert(20);
        orderedArray.insert(70);
        orderedArray.insert(10);
        orderedArray.insert(-40);
        orderedArray.insert(22);
        orderedArray.insert(9);
        orderedArray.display();
        System.out.println(orderedArray.search(20));
    }
}
