package com.me.recursion;

import com.me.array.OrderedArray;

public class BinarySearch extends OrderedArray {

    public BinarySearch(int size) {
        super(size);
    }

    public int search(int value){
        return searchRec(value, 0, elementsCount - 1);
    }

    public int searchRec(int value, int left, int right){
        int center = (left + right) / 2;
        if (arr[center] == value) return center;
        if (left > right) return -1;
        if (arr[center] > value){
            return searchRec(value, left, center - 1);
        } else {
            return searchRec(value, center + 1, right);
        }
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
        System.out.println(orderedArray.search(270));
    }
}
