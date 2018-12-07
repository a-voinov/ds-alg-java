package com.me.hashtable.impl.open;

import com.me.hashtable.domain.Employee;
import com.me.hashtable.impl.HashTableOpenAddressing;

/**
 * Hash Table with Linear Probing implemented
 */
public class HashTableLinearProbing extends HashTableOpenAddressing {

    @Override
    protected int getIndex(int key) {
        return ++key;
    }

    public static void main(String[] args){
        Employee john = new Employee("John", "Doe", 123);
        Employee jane = new Employee("Jane", "Jones", 145);
        Employee mary = new Employee("Mary", "Smith", 6584);
        Employee mike = new Employee("Mike", "Wilson", 119);
        HashTableLinearProbing hashTable = new HashTableLinearProbing();
        hashTable.put("Doe", john);
        hashTable.put("Jones", jane);
        hashTable.put("Wilson", mike);
        hashTable.put("Smith", mary);
        System.out.println();
        hashTable.display();
        System.out.println();
        System.out.println("Retrieve Wilson : " + hashTable.get(mike.getLastName()));
        System.out.println("Retrieve Smith : " + hashTable.get(mary.getLastName()));

        System.out.println();
        hashTable.remove(mike.getLastName());
        hashTable.remove(jane.getLastName());
        hashTable.display();

        System.out.println();
        System.out.println("Retrieve Smith : " + hashTable.get(mary.getLastName()));
    }

}
