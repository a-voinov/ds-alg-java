package com.me.hashtable.impl;

import com.me.domain.Employee;
import com.me.domain.StoredEmployee;
import com.me.hashtable.IHashTable;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Hash Table with Chaining implemented.
 * (Linked List used to handle collisions)
 */
public class HashTableChaining implements IHashTable {

    private LinkedList<StoredEmployee>[] hashtable;

    public HashTableChaining() {
        hashtable = new LinkedList[10];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<>();
        }
    }

    @Override
    public void put(String key, Employee value) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, value));
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    private StoredEmployee findKey(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee;
        while (iterator.hasNext()){
            employee = iterator.next();
            if (employee.getKey().equals(key)){
                return employee;
            }
        }
        return null;
    }

    @Override
    public Employee get(String key) {
       return findKey(key);
    }

    @Override
    public Employee remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = 0;
        while (iterator.hasNext()){
            employee = iterator.next();
            if (employee.getKey().equals(key)){
                break;
            }
            index++;
        }
        if (employee == null){
            return null;
        } else {
            hashtable[hashedKey].remove(index);
            return employee;
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i].isEmpty()){
                System.out.println(
                        "Position " + i  + " is empty"
                );
            } else {
                System.out.println("Position " + i  + " : ");
                for (StoredEmployee employee : hashtable[i]) {
                    System.out.print(employee);
                    System.out.print("->");
                }
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args){
        Employee john = new Employee("John", "Doe", 123);
        Employee jane = new Employee("Jane", "Jones", 145);
        Employee mary = new Employee("Mary", "Smith", 6584);
        Employee mike = new Employee("Mike", "Wilson", 119);
        HashTableChaining hashTable = new HashTableChaining();
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
