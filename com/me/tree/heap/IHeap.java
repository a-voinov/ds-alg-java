package com.me.tree.heap;

/**
 * Common heap (data structure) operations
 */
public interface IHeap {
    /**
     *  Retrieve root element from the heap
     */
    int peek();
    /**
     * Print heap to stdout
     */
    void printHeap();
    /**
     *  Method inserts element into heap
     */
    void insert(int value);
    /**
     *  Method removes element with specified index from heap
     */
    int delete(int index);
}
