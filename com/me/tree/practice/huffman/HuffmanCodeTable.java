package com.me.tree.practice.huffman;

import java.util.HashMap;
import java.util.Map;

/**
 * Encapsulation of HashMap (Character -> Huffman code)
 */
public class HuffmanCodeTable {

    private HashMap<Character, String> codeTable;

    public HuffmanCodeTable() {
        this.codeTable = new HashMap<>();
    }

    public void put(char c, String code){
        codeTable.put(c, code);
    }

    public String getCode(Character c){
        return codeTable.get(c);
    }

    public void display(){
        System.out.println("----->> HUFFMAN TREE <<-----");
        for (Map.Entry<Character, String> entry : codeTable.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }
        System.out.println("---------------------------");
    }

}
