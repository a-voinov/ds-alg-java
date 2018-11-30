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

    int maxElementPosition(){
        if (data[1] == null){
            return 0;
        }
        if (data[2] == null){
            return 1;
        }
        return 2;
    }

    int remove(int elementNum){
        int el = data[elementNum];
        data[elementNum] = null;
        return el;
    }

    int removeAndShift(int elementNum){
        int el = data[elementNum];
        data[elementNum] = null;
        //shift
        if (elementNum == 1){
            data[1] = data[2];
            data[2] = null;
        } else
        if (elementNum == 0){
            data[0] = data[1];
            data[1] = data[2];
            data[2] = null;
        }
        return el;
    }

    @Override
    public String toString() {
        return "TreeNode234{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
