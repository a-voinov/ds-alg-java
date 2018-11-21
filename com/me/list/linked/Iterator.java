package com.me.list.linked;

import com.me.list.IIterator;
import com.me.list.ILink;

/**
 * Implementation of IIterator for Singly Linked List
 */
public class Iterator implements IIterator {

    AbstractLinkedList list;
    Link current;
    Link previous;

    Iterator(AbstractLinkedList list) {
        this.list = list;
        reset();
    }

    @Override
    public void reset() {
        current = (Link)list.getFirst();
        previous = null;
    }

    @Override
    public void next() {
        previous = current;
        current = current.next;
    }

    @Override
    public ILink getCurrent() {
        return current;
    }

    @Override
    public boolean atEnd() {
        return current.next == null;
    }

    protected Link newLink;

    @Override
    public void insertAfter(int value) {
        if (list.isEmpty()){
            list.addFirst(value);
        } else {
            //create
            newLink = new Link();
            newLink.data = value;
            //link
            newLink.next = current.next;
            if (current.next != null){
                current.next.prev = newLink;
            }
            newLink.prev = current;
            current.next = newLink;
        }
        //inc size
        list.size++;
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
            if (previous != null) {
                newLink.prev = previous;
                previous.next = newLink;
            }
            previous = newLink;
            //move head
            if (newLink.prev == null) {
                list.head = newLink;
            }
        }
        //inc size
        list.size++;
    }

    @Override
    public void deleteCurrent() {
        if (previous == null){
            //at the end of the list
            list.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()) reset(); else
                current = current.next;
        }
        //dec size
        list.size--;
        //move head
        if (current.prev == null) {
            list.head = current;
        }
    }
}
