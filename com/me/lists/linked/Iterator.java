package com.me.lists.linked;

import com.me.lists.IIterator;
import com.me.lists.ILink;
import com.me.lists.IList;

/**
 * Implementation of IIterator for Linked List
 */
public class Iterator implements IIterator {

    private IList list;
    private Link current;
    private Link previous;

    Iterator(IList list) {
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

    @Override
    public void insertAfter(int value) {
        if (list.isEmpty()){
            list.addFirst(value);
        } else {
            //create
            Link newLink = new Link();
            newLink.data = value;
            //link
            newLink.next = current.next;
            newLink.prev = current;
            current.next = newLink;
        }
    }

    @Override
    public void insertBefore(int value) {
        if (list.isEmpty()){
            list.addFirst(value);
        } else {
            //create
            Link newLink = new Link();
            newLink.data = value;
            //link
            newLink.next = current;
            current.prev = newLink;
            if (previous != null) {
                newLink.prev = previous;
                previous.next = newLink;
            }
            previous = current.prev;
        }
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
    }
}
