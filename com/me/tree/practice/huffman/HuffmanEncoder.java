package com.me.tree.practice.huffman;

import java.util.*;

/**
 *  Huffman encoder implementation
 */
public class HuffmanEncoder {

    private HashMap<Character, Integer> createFrequencyMap(String text){
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (frequencyMap.containsKey(c)){
                int f = frequencyMap.get(c);
                frequencyMap.put(c, ++f);
            } else {
                frequencyMap.put(c, 1);
            }
        }
        return frequencyMap;
    }

    private void concatTrees(PriorityQueue<HuffmanTree> queue){
        HuffmanTree first = queue.poll();
        HuffmanTree second = queue.poll();
        HuffmanTree newTree = new HuffmanTree(null,
                first.root.getFrequency() + second.root.getFrequency());
        newTree.root.left = first.root;
        newTree.root.right = second.root;
        queue.offer(newTree);
    }

    private HuffmanTree createTree(String text){
        //collect frequency data about every character in String
        HashMap<Character, Integer> frequencyMap = createFrequencyMap(text);
        //create Tree Set with frequency data as Root Node for every Character
        List<HuffmanTree> treeList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            treeList.add(new HuffmanTree(entry.getKey(), entry.getValue()));
        }
        //sort list of trees by frequency
        PriorityQueue<HuffmanTree> treeQueue = new PriorityQueue<>(treeList);
        //create huffman tree
        while (treeQueue.size() > 1) concatTrees(treeQueue);
        return treeQueue.poll();
    }

    private HuffmanTree huffmanTree;


    public String encode(String text){
        HuffmanTree tree = createTree(text);
        this.huffmanTree = tree;
        HuffmanCodeTable codeTable = tree.getCodeTable();
        codeTable.display();
        //encode string
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            encoded.append(codeTable.getCode(c));
        }
        return encoded.toString();
    }

    public String decode(String text){
        StringBuilder decodeBuilder = new StringBuilder();
        HuffmanTreeNode node = huffmanTree.root;
        for (char c : text.toCharArray()) {
            if (c == '0'){
                if (node.left != null){
                    node = node.left;
                } else {
                    node = huffmanTree.root.left;
                }
            } else { // c == '1'
                if (node.right != null){
                    node = node.right;
                } else {
                    node = huffmanTree.root.right;
                }
            }
            if (node.getSymbol() != null) decodeBuilder.append(node.getSymbol());
        }
        return decodeBuilder.toString();
    }

    public static void main(String[] args){
        /** example usage **/
        String text = "SUSIE SAYS IT IS EASY";
        HuffmanEncoder encoder = new HuffmanEncoder();
        String encoded = encoder.encode(text);
        System.out.println("Encoded string : " + encoded);
        System.out.println("Decoded cypher : " + encoder.decode(encoded));
    }

}
