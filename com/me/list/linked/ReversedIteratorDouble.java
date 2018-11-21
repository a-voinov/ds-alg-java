package com.me.list.linked;

/**
 * Reversed Iterator implemented for Doubly Linked List
 */
public class ReversedIteratorDouble extends ReversedIterator {

    ReversedIteratorDouble(AbstractLinkedList list) {
        super(list);
    }

    @Override
    public void insertAfter(int value) {
        super.insertAfter(value);
        if (newLink.next == null) {
            ((DoubleLinkedList) list).tail = newLink;
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
