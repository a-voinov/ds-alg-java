package com.me.tree.practice.huffman;

/**
 * Huffman Tree implementation
 */
public class HuffmanTree implements Comparable<HuffmanTree> {

    HuffmanTreeNode root;

    private StringBuilder codeBuilder;
    private HuffmanCodeTable codeTable;

    public HuffmanCodeTable getCodeTable() {
        if (codeTable == null) buildCodeTable();
        return codeTable;
    }

    public void buildCodeTable(){
        codeTable = new HuffmanCodeTable();
        codeBuilder = new StringBuilder();
        traverse();
    }

    private void visit(HuffmanTreeNode node){
        if (node != null && node.getSymbol() != null){
            codeTable.put(node.getSymbol(), codeBuilder.toString());
        }
    }

    /**
     * infix traverse
     */
    private void traverse(HuffmanTreeNode node){
        visit(node);
        if (node.left != null){
            codeBuilder.append('0');
            traverse(node.left);
        }
        if (node.right != null) {
            codeBuilder.append('1');
            traverse(node.right);
        }
        if (codeBuilder.length() > 0)
            codeBuilder.deleteCharAt(codeBuilder.length() - 1);
    }

    private void traverse(){
        if (root != null){
            traverse(root);
        }
    }

    public HuffmanTree(Character c, int f) {
        this.root = new HuffmanTreeNode(c, f);
    }

    @Override
    public int compareTo(HuffmanTree o) {
        return root.getFrequency() - o.root.getFrequency();
    }
}