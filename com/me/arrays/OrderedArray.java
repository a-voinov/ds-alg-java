package com.me.arrays;

/**
 * Ordered array
 */
public class OrderedArray extends UnorderedArray {

    public OrderedArray(int size) {
        super(size);
    }

    @Override
    public void insert(int value) {
        //finding index to insert value
        int i;
        for (i = 0; i < elementsCount; i++)
            if (arr[i]>value)
                break;
        //index shouldn't be higher than array length
        if (i >= arr.length)
            return;
        //if array is full, decrease counter by 1
        if (elementsCount == arr.length)
            elementsCount--;
        //elements shifting
        for (int j = elementsCount; j > i; j--){
            arr[j] = arr[j-1];
        }
        //inserting value
        arr[i] = value;
        //increasing counter
        elementsCount++;
    }

    @Override
    public void insert(int index, int value) {
        //overriding simple insert by index
        this.insert(value);
    }

    @Override
    public void remove(int index) {
        //shifting elements
        for (int i = index; i < elementsCount-1 ; i++) {
            arr[i] = arr[i+1];
        }
        //decrease counter
        elementsCount--;
        //remove element
        super.remove(elementsCount);
    }

}
