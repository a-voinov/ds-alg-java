package com.me.tree.heap.impl;

/**
 * Max-Heap with heap sort implemented
 */
public class MaxHeapSortable extends MaxHeap {

    public MaxHeapSortable(int capacity) {
        super(capacity);
    }

    /**
     * Method sorts array, but also completely ruins heap structure
     */
    public void sort(){
        int lastHeapIndex = size - 1;
        for (int i = 0; i < lastHeapIndex; i++) {
            //1. swap root and last not sorted element pos
            int tmp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = tmp;
            //2. heapify array
            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }

}
