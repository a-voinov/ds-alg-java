package com.me.tree.impl.twofour;

import com.me.tree.ITree;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

/**
 * Tree 2-3-4 implementation without deletion
 */
public class Tree234 implements ITree {

    protected TreeNode234 root;

    private void divideNonRootNode(TreeNode234 node, int value){
        TreeNode234 newRightNode = new TreeNode234();
        //rightmost element goes to first element of new right node
        newRightNode.data[0] = node.data[2];
        //middle element goes to parent node
        TreeNode234 parentNode = node.parent;
        if (parentNode.data[1] == null){
            if (parentNode.data[0] > node.data[1]){
                parentNode.data[1] = parentNode.data[0];
                parentNode.data[0] = node.data[1];
            } else
                parentNode.data[1] = node.data[1];
        } else
         if (parentNode.data[0] > node.data[1] && parentNode.data[1] > node.data[1]){
            //shift 2 elements
             parentNode.data[2] = parentNode.data[1];
             parentNode.data[1] = parentNode.data[0];
             parentNode.data[0] = node.data[1];
         } else
         if (parentNode.data[0] < node.data[1] && parentNode.data[1] > node.data[1]){
            //shift mid element
             parentNode.data[2] = parentNode.data[1];
             parentNode.data[1] = node.data[1];
         }
         else
         {
             //insert at rightmost pos
             parentNode.data[2] = node.data[1];
         }

        //clear data
        node.data[1] = null;
        node.data[2] = null;
        //set new relations
        newRightNode.parent = parentNode;
        newRightNode.node1 = node.node3;
        if (newRightNode.node1 != null)
            newRightNode.node1.nodeNum = 1;
        newRightNode.node2 = node.node4;
        if (newRightNode.node2 != null)
            newRightNode.node2.nodeNum = 2;
        //find insertion point for new node
        //----insert new node
        TreeNode234 node3 = parentNode.node3;
        TreeNode234 node2 = parentNode.node2;
        switch (node.nodeNum){
            case 1:
                newRightNode.nodeNum = 2;
                parentNode.node2 = newRightNode;
                parentNode.node3 = node2;
                if (parentNode.node3 != null) parentNode.node3.nodeNum = 3;
                parentNode.node4 = node3;
                if (parentNode.node4 != null) parentNode.node4.nodeNum = 4;
                break;
            case 2:
                newRightNode.nodeNum = 3;
                parentNode.node3 = newRightNode;
                parentNode.node4 = node3;
                if (parentNode.node4 != null) parentNode.node4.nodeNum = 4;
                break;
            case 3:
                newRightNode.nodeNum = 4;
                parentNode.node4 = newRightNode;
                break;
        }
        //clear relations
        node.node3 = null;
        node.node4 = null;

        insert(parentNode, value,false);
    }

    private void divideRoot(int value){
        TreeNode234 newRoot = new TreeNode234();
        //middle element goes to first element of new root
        newRoot.data[0] = root.data[1];
        newRoot.node1 = root;
        root.nodeNum = 1;
        TreeNode234 newRightNode = new TreeNode234();
        //rightmost element goes to first element of new right node
        newRightNode.data[0] = root.data[2];
        newRoot.node2 = newRightNode;
        newRightNode.nodeNum = 2;
        //move two right links from old root to new root
        newRightNode.node1 = root.node3;
        newRightNode.node2 = root.node4;
        if (newRightNode.node1 != null) {
            newRightNode.node1.parent = newRightNode;
            newRightNode.node1.nodeNum = 1;
        }
        if (newRightNode.node2 != null) {
            newRightNode.node2.parent = newRightNode;
            newRightNode.node2.nodeNum = 2;
        }
        //clear data
        root.data[1] = null;
        root.data[2] = null;
        root.node3 = null;
        root.node4 = null;
        //set parent relations
        root.parent = newRoot;
        newRightNode.parent = newRoot;
        //change root
        root.isRoot = false;
        root = newRoot;
        newRoot.isRoot = true;
        insert(newRoot, value, false);
    }

    protected void insert(TreeNode234 node, int value, boolean divideFirst){

        //1. division
        if (divideFirst)
        if (node.data[1] != null && node.data[2] != null){
            //divide root
            if (node.isRoot) divideRoot(value); else
                //divide non-root node
                divideNonRootNode(node, value);
            return;
        }
        //2. branching
        if (node.node1 != null &&
                value < node.data[0]) {
            insert(node.node1, value, true);
            return;
        } else
        if (node.node2 != null &&
                value > node.data[0] && (node.data[1] == null || value < node.data[1]) ){
            insert(node.node2, value, true);
            return;
        }
        else
        if (node.node3 != null && node.data[1] != null &&
                value > node.data[1] && (node.data[2] == null || value < node.data[2])) {
            insert(node.node3, value, true);
            return;
        } else
        if (node.node4 != null && node.data[2] != null &&
                value > node.data[2]) {
            insert(node.node4, value, true);
            return;
        }
        //3. insertion
        if (node.data[1] == null){
            if (node.data[0] > value){
                node.data[1] = node.data[0];
                node.data[0] = value;
            } else
                node.data[1] = value;
        } else
        if (node.data[2] == null){
            if (node.data[0] > value){
                node.data[2] = node.data[1];
                node.data[1] = node.data[0];
                node.data[0] = value;
            } else if (node.data[1] > value) {
                node.data[2] = node.data[1];
                node.data[1] = value;
            } else {
                node.data[2] = value;
            }
        }

    }

    @Override
    public void insert(int value) {
        if (root == null){
            root = new TreeNode234();
            root.isRoot = true;
            root.data[0] = value;
        } else {
            insert(root, value, true);
        }
    }

    protected void traverse(TreeNode234 node){
        if (node == null) return;
        visit(node);
        if (node.node1 != null)
            traverse(node.node1);
        if (node.node2 != null)
            traverse(node.node2);
        if (node.node3 != null)
            traverse(node.node3);
        if (node.node4 != null)
            traverse(node.node4);
    }

    protected void visit(TreeNode234 node){
        if (node == null) return;
        if (node.data == null) System.out.print("[empty] ");  else
        System.out.print(Arrays.toString(node.data) + " ");
    }

    @Override
    public void traverseInOrder() {
        traverse(root);
        System.out.println();
    }

    protected TreeNode234 get(TreeNode234 node, int value){
        for (int i = 0; i < 3; i++) {
            if (node.data[i] == null) break;
            if (node.data[i] == value) return node;
        }
        if (value < node.data[0])
            return get(node.node1, value);
        if ((node.data[1] != null &&
                value > node.data[0] && value < node.data[1]) ||
                node.data[1] == null)
            return get(node.node2, value);
        if (node.data[2] != null &&
                value > node.data[1] && value < node.data[2])
            return get(node.node3, value);
        if (node.data[2] != null &&
                value > node.data[2])
            return get(node.node4, value);
        return null;
    }

    @Override
    public TreeNode234 get(int value) {
        return get(root, value);
    }

    protected TreeNode234 minNode(TreeNode234 node){
        if (node.node1 == null) {
            return node;
        } else return minNode(node.node1 );
    }

    protected TreeNode234 minNode(){
        return minNode(root);
    }

    @Override
    public int min() {
        return minNode().data[0];
    }

    protected TreeNode234 maxNode(TreeNode234 node){
        TreeNode234 curNode = node;
        if (node.node1 != null) curNode = node.node2;
        if (node.node2 != null) curNode = node.node2;
        if (node.node3 != null) curNode = node.node3;
        if (node.node4 != null) curNode = node.node4;

        if (curNode.node1 == null && curNode.node2 == null && curNode.node3 == null && curNode.node4 == null)
            return curNode;
        else return maxNode(curNode);
    }

    /**
     * retrieve node with maximum tree element
     */
    protected TreeNode234 maxNode(){
        return maxNode(root);
    }

    @Override
    public int max() {
        TreeNode234 maxNode = maxNode();
        int maxElementPos = maxNode.maxElementPosition();
        return maxNode.data[maxElementPos];
    }

    @Override
    public void delete(int val) {
        throw new NotImplementedException();
    }

    public void display(){
        traverseInOrder();
    }

    public static void main(String[] args){
        Tree234 tree234 = new Tree234();
        tree234.insert(70);
        tree234.insert(50);
        tree234.insert(30);
        tree234.display();
        tree234.insert(40);
        tree234.display();
        tree234.insert(20);
        tree234.insert(80);
        tree234.display();
        tree234.insert(25);
        tree234.insert(90);
        tree234.display();
        tree234.insert(75);
        tree234.display();
        tree234.insert(10);
        tree234.display();
        System.out.println("min : " + tree234.min());
        System.out.println("max : " + tree234.max());
        System.out.println("get node with 20 : " + tree234.get(20));
        System.out.println("get node with 90 : " + tree234.get(90));
        System.out.println("get node with 10 : " + tree234.get(10));
        System.out.println("get node with 40 : " + tree234.get(40));
    }
}
