package com.me.queue.impl;

import com.me.queue.IQueue;

import java.util.NoSuchElementException;

/**
 * Circular Queue implementation with array under the hood
 */
public class CircularQueueArray implements IQueue {

    private int[] queue;
    private int front;
    private int rear;

    public CircularQueueArray(int capacity) {
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    @Override
    public void enqueue(int value) {
       if ((rear == queue.length - 1 && front == 0) || rear == front - 1){
            throw new IndexOutOfBoundsException();
       }
       if (rear == queue.length - 1 && front != 0) {
           //end of array has been reached
           rear = 0;
           queue[rear] = value;
           return;
       }
       queue[++rear] = value;
       if (front == -1){
           front = 0;
       }
    }

    @Override
    public int dequeue() {
        if (front == -1){
            throw new NoSuchElementException();
        }
        int val = queue[front++];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else
        if (front == queue.length - 1){
            front = 0;
        }
        return val;
    }

    @Override
    public int peek() {
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public int length() {
        if (front == -1){
            return 0;
        }
        if (rear < front){
            return rear - front + queue.length + 1;
        }
        return rear - front + 1;
    }

    /**
     * display queue in circular form
     */
    public void displayCircular(){
        if (rear < front) {
            System.out.print(queue[0]);
            for (int i = 1; i <= rear; i++) {
                System.out.print("," + queue[i]);
            }
            for (int i = front; i < queue.length; i++) {
                System.out.print("," + queue[i]);
            }
        } else {
            System.out.print(queue[front]);
            for (int i = front + 1; i <= rear; i++) {
                System.out.print("," + queue[i]);
            }
        }
        System.out.println();
    }

    @Override
    public void display() {
        if (rear < front) {
            System.out.print(queue[front]);
            for (int i = front + 1; i < queue.length; i++) {
                System.out.print("," + queue[i]);
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print("," + queue[i]);
            }
        } else {
            System.out.print(queue[front]);
            for (int i = front + 1; i <= rear; i++) {
                System.out.print("," + queue[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        CircularQueueArray queueArray = new CircularQueueArray(5);
        queueArray.enqueue(1);
        queueArray.enqueue(2);
        queueArray.enqueue(3);
        queueArray.enqueue(4);
        queueArray.dequeue();
        queueArray.dequeue();
        queueArray.enqueue(5);
        queueArray.enqueue(6);
        queueArray.enqueue(7);
        queueArray.display();
        queueArray.displayCircular();
        System.out.println("peek : " + queueArray.peek());
        System.out.println("length : " + queueArray.length());
    }
}
