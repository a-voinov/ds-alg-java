package com.me.lists.linked;

/**
 * Iterator implemented for Doubly Linked List
 */
public class IteratorDouble extends Iterator {

    IteratorDouble(AbstractLinkedList list) {
        super(list);
    }

    @Override
    public void insertAfter(int value) {
        super.insertAfter(value);
    }

    @Override
    public void insertBefore(int value) {
        super.insertBefore(value);
        if (current.next == null) {
            ((DoubleLinkedList) list).tail = current;
        }
    }

    @Override
    public void deleteCurrent() {
        super.deleteCurrent();
        if (current.next == null) {
            ((DoubleLinkedList) list).tail = current;
        }
    }
}
