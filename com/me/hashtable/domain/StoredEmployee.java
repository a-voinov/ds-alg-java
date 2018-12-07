package com.me.hashtable.domain;

/**
 * Wrapper on class Employee for hash table implementations.
 * This wrapper helps to solve the problem of hash collisions.
 */
public class StoredEmployee extends Employee {

    private String key;

    public StoredEmployee(String key, String firstName, String lastName, int id) {
        super(firstName, lastName, id);
        this.key = key;
    }

    public StoredEmployee(String key, Employee employee) {
        super(employee.getFirstName(), employee.getLastName(), employee.getId());
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
