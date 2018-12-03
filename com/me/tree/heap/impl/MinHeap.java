package com.me.tree.heap.impl;

/**
 * Min-Heap implementation
 */
public class MinHeap extends MaxHeap {

    MinHeap(int capacity) {
        super(capacity);
    }

    @Override
    protected void fixHeapAbove(int index) {
        int newVal = heap[index];
        while (index > 0 && newVal < heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newVal;
    }

    @Override
    protected void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;
        while (index <= lastHeapIndex){
            int leftChild =  getChild(index, true);
            int rightChild =  getChild(index, false);
            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex)
                    childToSwap = leftChild;
                else
                    childToSwap = heap[leftChild] < heap[rightChild] ? leftChild : rightChild;

                if (heap[index] > heap[childToSwap]) {
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                } else
                    break;

                index = childToSwap;
            } else
                break;
        }
    }

    public static void main(String args[]){
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(20);
        minHeap.insert(13);
        minHeap.insert(75);
        minHeap.insert(60);
        minHeap.insert(1);
        minHeap.insert(70);
        minHeap.insert(77);
        minHeap.printHeap();
        minHeap.delete(0);
        minHeap.printHeap();
        minHeap.delete(3);
        minHeap.printHeap();
        minHeap.delete(1);
        minHeap.printHeap();
    }
}
