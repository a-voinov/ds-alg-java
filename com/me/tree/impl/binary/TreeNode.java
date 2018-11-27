package com.me.tree.impl.binary;

import com.me.tree.ITreeNode;

/**
 *  Simple Tree Node with integer value as data
 */
public class TreeNode implements ITreeNode {

    private int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
