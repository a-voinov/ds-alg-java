package com.me.stack.impl;

import com.me.stack.IStack;

import java.util.EmptyStackException;

/**
 * Stack implementation with array under the hood
 */
public class StackArray implements IStack {

    private Integer[] stack;
    private int top;

    public StackArray(int capacity) {
        stack = new Integer[capacity];
        top = 0;
    }

    @Override
    public void push(int value) {
        if (top == stack.length){
            Integer[] biggerStack = new Integer[stack.length + stack.length / 2];
            System.arraycopy(stack, 0, biggerStack, 0, stack.length);
            stack = biggerStack;
        }
        stack[top++] = value;
    }

    @Override
    public int pop() {
        if (top == 0){
            throw new EmptyStackException();
        }
        return stack[--top];
    }

    @Override
    public boolean isEmpty(){
        return top == 0;
    }

    @Override
    public int length() {
        return top;
    }

    @Override
    public void display() {
        System.out.print("{ " + stack[top - 1]);
        for (int i = top - 2; i >= 0; i--){
            System.out.print(" <- " + stack[i] );
        }
        System.out.println(" }");
    }

    @Override
    public int peek() {
        if (top == 0){
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public static void main(String[] args){
        StackArray stackArray = new StackArray(4);
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);
        stackArray.push(4);
        stackArray.display();
        stackArray.push(5);
        stackArray.push(6);
        stackArray.push(7);
        stackArray.display();
        System.out.println("pop : " + stackArray.pop());
        System.out.println("pop : " + stackArray.pop());
        System.out.println("pop : " + stackArray.pop());
        System.out.println("peek : " + stackArray.peek());
        System.out.println("peek : " + stackArray.peek());
        stackArray.display();
    }
}
