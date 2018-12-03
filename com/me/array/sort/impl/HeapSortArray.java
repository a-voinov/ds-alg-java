package com.me.array.sort.impl;

import com.me.array.UnorderedArray;
import com.me.tree.heap.impl.MaxHeapSortable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Array with heap sort implemented
 */
public class HeapSortArray extends UnorderedArray {

    private MaxHeapSortable heap;

    public HeapSortArray(int size) {
        super(size); //default array isn't used here
        heap = new MaxHeapSortable(size); // instead Max-Heap is being used
    }

    @Override
    public void insert(int value) {
        heap.insert(value);
    }

    @Override
    public void remove(int index) {
        heap.delete(index);
    }

    public void sort(){
        //implementation encapsulated inside the heap object
        heap.sort();
    }

    @Override
    public void display() {
        heap.printHeap();
    }

    public static void main(String[] args) {
        int size = 300_000;
        Random random = new Random();
        HeapSortArray array = new HeapSortArray(size);
        /*for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(size) + 1);
        }*/
        array.insert(80);
        array.insert(75);
        array.insert(60);
        array.insert(68);
        array.insert(55);
        array.insert(40);
        array.insert(52);
        array.insert(67);

        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
        array.display();

        long elapsedTime = measureEnd  -  measureStart;
        System.out.println("array sorted with heap sort in " + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " seconds");
    }
}
