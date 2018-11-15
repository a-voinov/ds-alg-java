package com.me.queue.impl;

import com.me.queue.IQueue;

import java.util.NoSuchElementException;

/**
 * Queue implementation with array under the hood.
 * This queue is dynamically expandable.
 */
public class QueueArray implements IQueue {

    private int[] queue;
    private int front;
    private int rear;

    public QueueArray(int capacity) {
        queue = new int[capacity];
    }

    @Override
    public void enqueue(int value) {
        if (rear == queue.length){
            int[] biggerQueue = new int[queue.length + queue.length / 2];
            System.arraycopy(queue, 0, biggerQueue, 0, queue.length);
            this.queue = biggerQueue;
        }
        queue[rear++] = value;
    }

    @Override
    public int dequeue() {
        if (length() <= 0){
            throw new NoSuchElementException();
        }
        int val = queue[front++];
        if (length() == 0){
            front = 0;
            rear = 0;
        }
        return val;
    }

    @Override
    public int peek() {
        if (length() <= 0){
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public int length() {
        return rear - front;
    }

    @Override
    public void display() {
        System.out.print("{ " + queue[front]);
        for (int i = front + 1; i < rear; i++){
            System.out.print(" <- " + queue[i] );
        }
        System.out.println(" }");
    }

    public static void main(String[] args){
        QueueArray queueArray = new QueueArray(4);
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
