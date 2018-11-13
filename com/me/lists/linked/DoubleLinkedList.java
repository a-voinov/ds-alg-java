package com.me.lists.linked;

/**
 * Implementation of the Doubly(double-sided) Linked IList
 */
public class DoubleLinkedList extends AbstractLinkedList {

    private Link tail;

    public DoubleLinkedList() {
        displayElementsSeparator = " < - > ";
    }

    @Override
    public void addFirst(int value) {
        if (head == null && tail == null){
            head = new Link();
            head.data = value;
            tail = head;
        } else {
            Link newElement = new Link();
            newElement.data = value;
            newElement.next = head;
            head.prev = newElement;
            head = head.prev;
        }
        size++;
    }

    @Override
    public void removeFirst() {
        if (head == null) return;
        if (head.next == null) {
            tail = null;
            head = null;
        } else {
            head.next.prev = null;
            head = head.next;
        }
        size--;
    }

    @Override
    public void addLast(int value) {
        if (head == null && tail == null){
            head = new Link();
            head.data = value;
            tail = head;
        } else {
            Link newElement = new Link();
            newElement.data = value;
            newElement.prev = tail;
            tail.next = newElement;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public void removeLast() {
        if (tail == null) return;
        if (tail.prev == null) {
            tail = null;
            head = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }
        size--;
    }

    public static void main(String[] args){
        DoubleLinkedList ll = new DoubleLinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.display();
        System.out.println("list length = " + ll.length());
        System.out.println("reverse ");
        ll.reverse();
        ll.display();
        System.out.println("reverse again");
        ll.reverse();
        ll.display();
        ll.removeLast();
        ll.display();
        ll.removeFirst();
        ll.display();
        ll.removeFirst();
        ll.display();
        System.out.println("list length again = " + ll.length());
        //test iterator
        System.out.println("---------====<TEST ITERATOR>====---------");
        Iterator iterator = ll.createIterator();
        while (!iterator.atEnd()){
            System.out.println(iterator.getCurrent().getData());
            iterator.next();
        }
        System.out.println(iterator.getCurrent().getData());
        iterator.reset();
        System.out.println("current data = " + iterator.getCurrent().getData());
        System.out.println("iterator next");
        iterator.next();
        System.out.println("current data = " + iterator.getCurrent().getData());
        iterator.insertAfter(7);
        System.out.println("insert 7 after 4");
        ll.display();
        System.out.println("insert 10 before 4");
        iterator.insertBefore(10);
        ll.display();
        System.out.println("delete 4");
        iterator.deleteCurrent();
        ll.display();
        System.out.println("delete 3");
        iterator.reset();
        iterator.deleteCurrent();
        ll.display();
        System.out.println("iterator next");
        iterator.next();
        System.out.println("current data = " + iterator.getCurrent().getData());
        System.out.println("iterator next");
        iterator.next();
        System.out.println("current data = " + iterator.getCurrent().getData());
        System.out.println("delete 5");
        iterator.deleteCurrent();
        ll.display();
    }
}
