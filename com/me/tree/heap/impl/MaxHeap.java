package com.me.tree.heap.impl;

import com.me.tree.heap.IHeap;

/**
 * Max-Heap implementation
 */
public class MaxHeap implements IHeap {

    protected int[] heap;
    protected int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
    }

    public boolean isFull(){
        return size == heap.length;
    }

    protected int getParent(int index){
        return (index - 1) / 2;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getChild(int index, boolean left){
        return 2 * index + (left ? 1 : 2);
    }

    @Override
    public void insert(int value){
        if (isFull()) throw new IndexOutOfBoundsException("Heap is full!");
        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    @Override
    public int delete(int index){
        if (isEmpty()) throw new IndexOutOfBoundsException("Heap is empty!");
        int parent = getParent(index);
        int deletedValue = heap[index];
        heap[index] = heap[size-1]; //replace with rightmost value in the heap
        if (index == 0 || heap[index] < heap[parent])
            fixHeapBelow(index, size - 1); else
            fixHeapAbove(index);
        size--;
        return deletedValue;
    }

    @Override
    public void printHeap(){
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + ",");
        }
        System.out.println();
    }

    /**
     *  Heapify elements above the indexed element
     */
    protected void fixHeapAbove(int index){
        int newVal = heap[index];
        while (index > 0 && newVal > heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newVal;
    }

    /**
     *  Heapify elements bellow the indexed element
     */
    protected void fixHeapBelow(int index, int lastHeapIndex){
        int childToSwap;
        while (index <= lastHeapIndex){
            int leftChild =  getChild(index, true);
            int rightChild =  getChild(index, false);
            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex)
                    childToSwap = leftChild;
                else
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;

                if (heap[index] < heap[childToSwap]) {
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

    public int peek(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return heap[0];
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args){
        MaxHeap heap = new MaxHeap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);
        heap.printHeap();
        //heap.delete(1);
        // heap.printHeap();
        System.out.println(heap.peek());
        heap.delete(0);
        System.out.println(heap.peek());
    }

}