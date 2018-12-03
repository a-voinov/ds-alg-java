package com.me.tree.heap.practice;

import com.me.queue.IQueue;
import com.me.tree.heap.impl.MaxHeap;

/**
 * Priority Queue based on Max-Heap
 */
public class PriorityQueue implements IQueue {

    private MaxHeap heap;

    public PriorityQueue(int capacity) {
        this.heap = new MaxHeap(capacity);
    }

    @Override
    public void enqueue(int value) {
        heap.insert(value);
    }

    @Override
    public int dequeue() {
        int val = heap.peek();
        heap.delete(0);
        return val;
    }

    @Override
    public int peek() {
        return heap.peek();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int length() {
        return heap.getSize();
    }

    @Override
    public void display() {
        heap.printHeap();
    }

    public static void main(String[] args){
        PriorityQueue priorityQueue = new PriorityQueue(10);
        priorityQueue.enqueue(30);
        priorityQueue.enqueue(50);
        priorityQueue.enqueue(15);
        priorityQueue.enqueue(15);
        priorityQueue.enqueue(70);
        priorityQueue.enqueue(40);
        priorityQueue.enqueue(20);
        priorityQueue.enqueue(70);
        priorityQueue.display();
        System.out.println("Priority dequeue : " + priorityQueue.dequeue());
        System.out.println("Priority dequeue : " + priorityQueue.dequeue());
        System.out.println("Priority dequeue : " + priorityQueue.dequeue());
        System.out.println("Priority dequeue : " + priorityQueue.dequeue());
        System.out.println("Priority dequeue : " + priorityQueue.dequeue());
        System.out.println("Priority dequeue : " + priorityQueue.dequeue());
        System.out.println("Priority dequeue : " + priorityQueue.dequeue());
        System.out.println("Priority dequeue : " + priorityQueue.dequeue());
    }

}
