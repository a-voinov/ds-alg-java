package com.me.array.search.impl;

import com.me.array.UnorderedArray;

public class LinearSearch extends UnorderedArray {
    public LinearSearch(int size) {
        super(size);
    }

    public int search(int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
