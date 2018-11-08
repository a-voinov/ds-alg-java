package com.me.arrays;

/**
 * Encapsulation of Java int array
 */
public class Array {

    protected int[] arr;

    public Array(int size){
        arr = new int[size];
    }

    public void insert(int index, int value){
        arr[index] = value;
    }

    public void remove(int index){
        arr[index] = 0;
    }

    public int get(int index){
        return arr[index];
    }

    public int size() {return arr.length;}

    public void display(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
        System.out.println();
    }

}
