package com.me.hashtable.impl;

import com.me.hashtable.domain.Employee;
import com.me.hashtable.IHashTable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Simple hash table without collision handling
 */
public class SimpleHashTable implements IHashTable {

    protected Employee[] hashtable;

    public SimpleHashTable() {
        hashtable = new Employee[10];
    }

    protected int hashKey(String key){
        return key.length() % hashtable.length;
    }

    @Override
    public void put(String key, Employee value){
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null){
            System.out.println("Sorry, there is already an Employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = value;
        }
    }

    @Override
    public Employee get(String key){
        int hashedKey = hashKey(key);
        return hashtable[hashedKey];
    }

    @Override
    public Employee remove(String key) {
        throw new NotImplementedException();
    }

    @Override
    public void display(){
        int i = 0;
        for (Employee employee : hashtable) {
            System.out.println(i + " : " + employee);
            i++;
        }
    }

    public static void main(String[] args){
        Employee john = new Employee("John", "Doe", 123);
        Employee jane = new Employee("Jane", "Jones", 145);
        Employee mary = new Employee("Mary", "Smith", 6584);
        Employee mike = new Employee("Mike", "Wilson", 119);
        SimpleHashTable hashTable = new SimpleHashTable();
        hashTable.put("Doe", john);
        hashTable.put("Jones", jane);
        hashTable.put("Wilson", mike);
        hashTable.put("Smith", mary);
        System.out.println();
        hashTable.display();
        System.out.println();
        System.out.println("Retrieve Wilson : " + hashTable.get(mike.getLastName()));
    }
}
