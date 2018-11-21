package com.me.queue.impl;

import com.me.list.linked.DoubleLinkedList;
import com.me.list.linked.ReversedIteratorDouble;
import com.me.queue.IQueue;

import java.util.NoSuchElementException;

/**
 * Priority Queue implementation with LinkedList under the hood.
 * Numeric integer used as a priority key.
 */
public class PriorityQueue implements IQueue {

    private DoubleLinkedList queue;

    public PriorityQueue() {
        queue = new DoubleLinkedList();
    }

    private void iteratorInsert(ReversedIteratorDouble iterator, int value){
        if (iterator.getCurrent().getData() < value){
            iterator.insertAfter(value);
        } else {
            iterator.insertBefore(value);
        }
    }

    @Override
    public void enqueue(int value) {
        if (length() == 0) {
            queue.addLast(value);
        } else {
            ReversedIteratorDouble iterator = queue.createReversedIterator();
            if (length() == 1)
                iteratorInsert(iterator, value);
            else {
                while (!iterator.atEnd()) {
                    if (iterator.getCurrent().getData() < value)
                        break;
                    iterator.next();
                }
                iteratorInsert(iterator, value);
            }
        }
    }

    @Override
    public int dequeue() {
        int val = queue.getLast().getData();
        queue.removeLast();
        return val;
    }

    @Override
    public int peek() {
        if (length() <= 0){
            throw new NoSuchElementException();
        }
        return queue.getLast().getData();
    }

    @Override
    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public int length() {
        return queue.length();
    }

    @Override
    public void display() {
        queue.display();
    }

    public static void main(String[] args){
        PriorityQueue priorityQueue = new PriorityQueue();
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
