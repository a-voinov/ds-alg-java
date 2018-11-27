package com.me.tree.impl.binary;

import com.me.tree.ITree;

/**
 *  Binary Search Tree implementation
 */
public class BinarySearchTree implements ITree {

    private TreeNode root;

    //-------------------insert-----------------------------
    private void insertRec(TreeNode node, int value){
        if (value == node.getData()){
            return; //implementation ignores duplicates
        }
        if (value < node.getData()){
            if (node.left == null){
                node.left = new TreeNode(value);
            } else {
                insertRec(node.left, value);
            }
        } else {
            if (node.right == null){
                node.right = new TreeNode(value);
            } else {
                insertRec(node.right, value);
            }
        }
    }

    @Override
    public void insert(int value){
        if (root == null){
            root = new TreeNode(value);
        } else {
            insertRec(root, value);
        }
    }

    //-------------------traverse-----------------------------
    private void traverseInOrderRec(TreeNode node){
        if (node.left != null){
            traverseInOrderRec(node.left);
        }
        visit(node);
        if (node.right != null){
            traverseInOrderRec(node.right);
        }
    }

    @Override
    public void traverseInOrder(){
        if (root != null){
            traverseInOrderRec(root);
        }
        System.out.println();
    }

    protected void visit(TreeNode node){
        System.out.print(node.getData() + " ");
    }

    //-------------------get-----------------------------
    private TreeNode getRec(TreeNode node, int value){
        if (value == node.getData()){
            return node;
        }
        if (value < node.getData()){
            if (node.left != null){
                return getRec(node.left, value);
            }
        } else {
            if (node.right != null) {
                return getRec(node.right, value);
            }
        }
        return null;
    }

    @Override
    public TreeNode get(int value){
        return getRec(root, value);
    }

    //-------------------min-----------------------------

    private int minRec(TreeNode node){
        return node.left == null ? node.getData() : minRec(node.left);
    }

    @Override
    public int min(){
        if (root == null) return Integer.MIN_VALUE;
        return root.left == null ? root.getData() : minRec(root);
    }

    //-------------------max-----------------------------

    private int maxRec(TreeNode node){
        return node.right == null ? node.getData() : maxRec(node.right);
    }

    @Override
    public int max(){
        if (root == null) return Integer.MAX_VALUE;
        return root.right == null ? root.getData() : maxRec(root);
    }

    //-------------------delete-----------------------------
    @Override
    public void delete(int val){
        root = deleteRec(root, val);
    }

    private TreeNode deleteRec(TreeNode subtreeRoot, int val){
        if (subtreeRoot == null){
            return null;
        }
        if (val < subtreeRoot.getData()){
            subtreeRoot.left = deleteRec(subtreeRoot.left, val);
        } else if (val > subtreeRoot.getData()){
            subtreeRoot.right = deleteRec(subtreeRoot.right, val);
        } else { //node value == val
            //cases 1 and 2: node has 0 or 1 children
            if (subtreeRoot.left == null){
                return subtreeRoot.right;
            } else if (subtreeRoot.right == null){
                return subtreeRoot.left;
            }
            //case 3: node to delete has two children
            subtreeRoot.setData(minRec(subtreeRoot.right)); // replace value with smallest val from right subtree
            subtreeRoot.right = deleteRec(subtreeRoot.right, subtreeRoot.getData()); //remove node with smallest val from right subtree
        }
        return subtreeRoot;
    }

    //-------------------tests-----------------------------
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.max());
        System.out.println(tree.min());
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
        tree.insert(17);
        tree.traverseInOrder();
        /*System.out.println(tree.get(8888));
        System.out.println(tree.get(22));
        System.out.println(tree.max());
        System.out.println(tree.min());
        tree.delete(17);
        tree.traverseInOrder();*/
        tree.delete(15);
        tree.traverseInOrder();
        tree.delete(27);
        tree.traverseInOrder();
        tree.delete(25);
        tree.traverseInOrder();
        tree.delete(888);
        tree.traverseInOrder();
    }

}
