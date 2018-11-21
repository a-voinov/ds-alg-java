package com.me.array;

/**
 * Unordered array with elements counter and special method 'insert at the end'
 */
public class UnorderedArray extends Array {

    public UnorderedArray(int size) {
        super(size);
    }

    protected int elementsCount = 0;

    @Override
    public int size() {
        return elementsCount;
    }

    public void insert(int value){
        arr[elementsCount] = value;
        elementsCount++;
    }
}
