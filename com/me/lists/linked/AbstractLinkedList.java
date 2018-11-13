package com.me.lists.linked;

import com.me.lists.ILink;
import com.me.lists.IList;

/**
 * Class provides a skeletal implementation of the Linked list
 */
public abstract class AbstractLinkedList implements IList {

    protected Link head;
    protected int size = 0;

    @Override
    public int indexOf(int val) {
        if (head == null) return -1;
        int index = 0;
        Link curLink = head;
        while (true){
            if (curLink.data == val){
                return index;
            }
            index++;
            curLink = curLink.next;
            if (curLink == null){
                return -1;
            }
        }
    }

    @Override
    public int get(int index) {
        if (head == null) throw new IndexOutOfBoundsException("Linked IList is empty");
        Link curLink = head;
        while (--index > 0){
            curLink = curLink.next;
        }
        if (curLink == null) throw new IndexOutOfBoundsException("Data can't be found");
        return curLink.data;
    }

    @Override
    public Iterator createIterator() {
        return new Iterator(this);
    }

    @Override
    public void setFirst(ILink link) {
        head = (Link)link;
    }

    @Override
    public ILink getFirst() {
        return head;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int length() {
        return size;
    }

    protected String displayElementsSeparator = " -> ";

    @Override
    public void display(){
        if (head == null) { System.out.println("linked list is empty"); return; }
        if (head.next == null) { System.out.println("{ " + head.data + " }"); return; }
        System.out.print("{ " + head.data + displayElementsSeparator);
        Link curLink = head.next;
        while (curLink.next != null){
            System.out.print(curLink.data + displayElementsSeparator);
            curLink = curLink.next;
        }
        System.out.println(curLink.data + " }");
    }

    /**
     * reverse order of elements in list
     * https://www.geeksforgeeks.org/reverse-a-linked-list/
     */
    public void reverse(){
        Link current = head;
        Link prev = null;
        Link next;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

}
