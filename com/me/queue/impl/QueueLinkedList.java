package com.me.queue.impl;

import com.me.list.linked.DoubleLinkedList;
import com.me.queue.IQueue;

import java.util.NoSuchElementException;

/**
 * Queue implementation with LinkedList under the hood.
 * This queue is dynamically expandable.
 */
public class QueueLinkedList implements IQueue {

    private DoubleLinkedList queue;

    public QueueLinkedList() {
        queue = new DoubleLinkedList();
    }

    @Override
    public void enqueue(int value) {
        queue.addFirst(value);
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
        QueueLinkedList queueArray = new QueueLinkedList();
        queueArray.enqueue(1);
        queueArray.enqueue(2);
        queueArray.enqueue(3);
        queueArray.enqueue(4);
        queueArray.enqueue(5);
        queueArray.display();
        System.out.println("dequeue : " + queueArray.dequeue());
        System.out.println("dequeue : " + queueArray.dequeue());
        System.out.println("dequeue : " + queueArray.dequeue());
        System.out.println("peek : " + queueArray.peek());
        System.out.println("peek : " + queueArray.peek());
        queueArray.display();
        System.out.println("dequeue : " + queueArray.dequeue());
        System.out.println("dequeue : " + queueArray.dequeue());
        queueArray.enqueue(6);
        queueArray.display();
    }
}
