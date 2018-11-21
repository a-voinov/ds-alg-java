package com.me.list.linked;

import com.me.list.ILink;

/**
 * Composite element of any LinkedList
 */
public class Link implements ILink {
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
