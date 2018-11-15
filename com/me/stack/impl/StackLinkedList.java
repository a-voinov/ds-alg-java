package com.me.stack.impl;

import com.me.lists.linked.SingleLinkedList;
import com.me.stack.IStack;

/**
 * Stack implementation with Linked List under the hood
 */
public class StackLinkedList implements IStack {

    private SingleLinkedList stack;

    public StackLinkedList() {
        stack = new SingleLinkedList();
        stack.setDisplaySeparator(" <- ");
    }

    @Override
    public void push(int value) {
        stack.addFirst(value);
    }

    @Override
    public int pop() {
        int value = stack.getFirst().getData();
        stack.removeFirst();
        return value;
    }

    @Override
    public int peek() {
        return stack.getFirst().getData();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int length() {
        return stack.length();
    }

    @Override
    public void display() {
        stack.display();
    }

    public static void main(String[] args){
        StackLinkedList stackArray = new StackLinkedList();
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
