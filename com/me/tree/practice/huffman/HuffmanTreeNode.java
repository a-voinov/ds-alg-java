package com.me.tree.practice.huffman;

/**
 * Huffman Tree Node
 */
public class HuffmanTreeNode {

    HuffmanTreeNode left;
    HuffmanTreeNode right;

    private Character symbol;
    private int frequency;

    public HuffmanTreeNode(Character symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    public Character getSymbol() {
        return symbol;
    }

    public int getFrequency() {
        return frequency;
    }

}
