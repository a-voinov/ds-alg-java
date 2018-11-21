package com.me.list.linked;

/**
 * Implementation of IIterator for Linked List.
 * Iterates from last element to first.
 */
public class ReversedIterator extends Iterator {

    ReversedIterator(AbstractLinkedList list) {
        super(list);
        reset();
    }

    @Override
    public void reset() {
        current = (Link) list.getLast();
        if (current != null) previous = current.prev;
    }

    @Override
    public void next() {
        previous = current;
        current = current.prev;
    }

    @Override
    public boolean atEnd() {
        return current.prev == null;
    }

    @Override
    public void insertBefore(int value) {
        if (list.isEmpty()){
            list.addFirst(value);
        } else {
            //create
            newLink = new Link();
            newLink.data = value;
            //link
            newLink.next = current;
            current.prev = newLink;
            previous = newLink;
            //move head
            if (newLink.prev == null) {
                list.head = newLink;
            }
        }
        //inc size
        list.size++;
    }
}
