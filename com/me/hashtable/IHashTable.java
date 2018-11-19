package com.me.hashtable;

import com.me.domain.Employee;

/**
 * Common hash table operations
 */
public interface IHashTable {
    /**
     * Method adds element to hash table
     */
    void put(String key, Employee value);
    /**
     * Method returns element from hash table
     */
    Employee get(String key);
    /**
     *  Method removes element from hash table and returns it
     */
    Employee remove(String key);
    /**
     * Show Hash Table in System.out from front to rear
     */
    void display();
}
