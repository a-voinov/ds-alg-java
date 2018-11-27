package com.me.tree.impl.twofour;

import com.me.tree.ITreeNode;

import java.util.Arrays;

/**
 *  Tree 2-3-4 Node with integer data values
 */
class TreeNode234 implements ITreeNode {

    boolean isRoot;
    Integer[] data;
    TreeNode234 node1;
    TreeNode234 node2;
    TreeNode234 node3;
    TreeNode234 node4;
    int nodeNum;
    TreeNode234 parent;

    TreeNode234() {
        this.data = new Integer[3];
    }

    @Override
    public String toString() {
        return "TreeNode234{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
