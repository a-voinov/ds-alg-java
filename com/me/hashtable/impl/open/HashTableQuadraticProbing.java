package com.me.hashtable.impl.open;

import com.me.domain.Employee;
import com.me.domain.StoredEmployee;
import com.me.hashtable.impl.HashTableOpenAddressing;

/**
 * Hash Table with Quadratic Probing implemented
 */
public class HashTableQuadraticProbing extends HashTableOpenAddressing {

    public HashTableQuadraticProbing() {
        hashtable = new StoredEmployee[9];
    }

    @Override
    protected int getIndex(int key) {
        return key * key % hashtable.length;
    }

    public static void main(String[] args){
        Employee john = new Employee("John", "Doe", 123);
        Employee jane = new Employee("Jane", "Jones", 145);
        Employee mary = new Employee("Mary", "Smith", 6584);
        Employee mike = new Employee("Mike", "Wilson", 119);
        HashTableQuadraticProbing hashTable = new HashTableQuadraticProbing();
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
