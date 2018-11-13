package com.me.lists;

/**
 * Interface presents object with common list methods
 */
public interface IList {
    /*
     *   Return index of element in linked list
     */
    int indexOf(int val);
    /**
     * Get data from list by index of link
     */
    int get(int index);
    /**
     * Get first element of list
     */
    ILink getFirst();
    /**
     * Return length of elements of linked list
     */
    int length();
    /**
     * Insert link after last element
     */
    void addLast(int value);
    /**
     * Remove last element
     */
    void removeLast();
    /**
     * Show linked list in System.out
     */
    void display();
    /**
     * Insert link before first element
     */
    void addFirst(int value);
    /**
     * Replace first element in list
     */
    void setFirst(ILink link);
    /**
     * Remove first element
     */
    void removeFirst();
    /**
     * Return true if list is empty
     */
    boolean isEmpty();
    /**
     *  return iterator
     */
    IIterator createIterator();
}
