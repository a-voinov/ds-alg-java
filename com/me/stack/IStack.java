package com.me.stack;

/**
 * LIFO operations
 */
public interface IStack {
    /**
     *  add new value on top of the stack
     */
    void push(int value);
    /**
     *  Get value from top of the stack. Value will be removed.
     */
    int pop();
    /**
     * Get value from top of the stack. Value will NOT be removed.
     */
    int peek();
    /**
     * returns true if stack is empty
     */
    boolean isEmpty();
    /**
     * Get count of elements in stack
     */
    int length();
    /**
     * Show stack in System.out
     */
    void display();
}
