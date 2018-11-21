package com.me.array.sort.impl;

import com.me.array.UnorderedArray;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Array with Shell sort implemented
 */
public class ShellSortArray extends UnorderedArray {
    public ShellSortArray(int size) {
        super(size);
    }

    public void sort(){
        int h = 1;
        while (h < elementsCount/3){
            h = h * 3 + 1;
        }
        while (h > 0){
            for(int outer = h; outer < elementsCount; outer++ ){
                int save = arr[outer];
                int inner = outer;
                while (inner > h-1 && arr[inner - h] >= save ){
                    arr[inner] = arr[inner - h];
                    inner -= h;
                }
                arr[inner] = save;
            }
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args){
        int size = 5_000_000;
        Random random = new Random();
        ShellSortArray array = new ShellSortArray(size);
        for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(size) + 1);
        }
        long measureStart = System.nanoTime();
        array.sort();
        long measureEnd = System.nanoTime();
        //array.display();

        long elapsedTime = measureEnd  -  measureStart;
        System.out.println("array sorted with Shell sort in " + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " seconds");

    }
}
