package com.me.lists.linked;

import com.me.lists.ILink;

/**
 * Composite element of any LinkedList
 */
class Link implements ILink {
    int data;
    Link next;
    Link prev;

    public int getData(){
        return data;
    }

    @Override
    public String toString() {
        return "Link{" +
                "data=" + data +
                '}';
    }
}