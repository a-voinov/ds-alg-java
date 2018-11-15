package com.me.queue;

/**
 * FIFO operations
 */
public interface IQueue {
    /**
     *  Add new value to the rear of the queue
     */
    void enqueue(int value);
    /**
     *  Get value from the front of the queue. Value will be removed.
     */
    int dequeue();
    /**
     *  Get value from the front of the queue. Value will NOT be removed.
     */
    int peek();
    /**
     * Returns true if queue is empty
     */
    boolean isEmpty();
    /**
     * Get count of elements in queue
     */
    int length();
    /**
     * Show queue in System.out from front to rear
     */
    void display();
}
