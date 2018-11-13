package com.me.lists;

public interface IIterator {
    /**
     *  Set Iterator to first element at List
     */
    void reset();
    /**
     *  Move iterator to next Link
     */
    void next();
    /**
     * Return element referenced by Iterator
     */
    ILink getCurrent();
    /**
     * Has Iterator reached the end of the List ?
     */
    boolean atEnd();
    /**
     *  Insert new element after an element referenced by Iterator
     */
    void insertAfter(int value);
    /**
     *  Insert new element before an element referenced by Iterator
     */
    void insertBefore(int value);
    /**
     * Remove element referenced by Iterator
     */
    void deleteCurrent();
}
