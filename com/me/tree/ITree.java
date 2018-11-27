package com.me.tree;

/**
 * Common Tree operations
 */
public interface ITree {
    /**
     * Insert element in Tree
     */
    void insert(int value);
    /**
     * Traverse Tree in ascending order of values
     */
    void traverseInOrder();
    /**
     * Get Tree Node by it's value
     */
    ITreeNode get(int value);
    /**
     * Method returns lowest value in Tree
     */
    int min();
    /**
     * Method returns highest value in Tree
     */
    int max();
    /**
     * Method removes Node with specified value from the Tree
     */
    void delete(int val);
}
