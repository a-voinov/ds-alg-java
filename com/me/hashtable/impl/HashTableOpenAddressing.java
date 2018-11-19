package com.me.hashtable.impl;

import com.me.domain.Employee;
import com.me.domain.StoredEmployee;

/**
 *  Open addressing strategy to handle collisions
 */
public abstract class HashTableOpenAddressing extends SimpleHashTable {

    public HashTableOpenAddressing() {
        hashtable = new StoredEmployee[10];
    }

    protected abstract int getIndex(int key);

    @Override
    public void put(String key, Employee value) {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey)){
            int stopIndex = hashedKey;
            if (hashedKey >= hashtable.length - 1) hashedKey = 0; // loop
            else hashedKey = getIndex(hashedKey);

            while (isOccupied(hashedKey) && hashedKey != stopIndex){
                hashedKey = getIndex(hashedKey) % hashtable.length;
            }
        }
        if (isOccupied(hashedKey)){
            System.out.println("Sorry, there is already an Employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, value);
        }
    }

    private int findKey(String key){
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey]!= null && ((StoredEmployee)hashtable[hashedKey]).getKey().equals(key))
            return hashedKey;

        int stopIndex = hashedKey;
        if (hashedKey >= hashtable.length - 1) hashedKey = 0; // loop
        else hashedKey = getIndex(hashedKey);

        while (hashedKey != stopIndex
                && hashtable[hashedKey] != null
                && !((StoredEmployee)hashtable[hashedKey]).getKey().equals(key)){
            hashedKey = getIndex(hashedKey) % hashtable.length;
        }

        if (hashtable[hashedKey] != null &&
                ((StoredEmployee)hashtable[hashedKey]).getKey().equals(key)){
            return hashedKey;
        } else {
            return -1;
        }
    }

    private boolean isOccupied(int index){
        if (index > hashtable.length) return true;
        return hashtable[index] != null;
    }

    @Override
    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1){
            return null;
        }
        return hashtable[hashedKey];
    }

    private void rehash(){
        StoredEmployee[] oldTable = (StoredEmployee[])hashtable;
        hashtable = new StoredEmployee[oldTable.length];
        for (StoredEmployee e : oldTable) {
            if (e != null) {
                put(e.getKey(), e);
            }
        }
    }

    @Override
    public Employee remove(String key){
        int hashedKey = findKey(key);
        if (hashedKey == -1){
            return null;
        }
        Employee employee = hashtable[hashedKey];
        hashtable[hashedKey] = null;
        //rehash table
        rehash();
        return employee;
    }

    @Override
    public void display() {
        int i = 0;
        for (Employee employee : hashtable) {
            if (employee == null){
                System.out.println(i + " : empty");
            } else {
                System.out.println(i + " : " + employee);
            }
            i++;
        }
    }

}
