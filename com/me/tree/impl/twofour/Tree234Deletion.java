package com.me.tree.impl.twofour;

/**
 *  Tree 2-3-4 deletion algorithm implementation
 */
public class Tree234Deletion extends Tree234 {

    private int elementsCount(TreeNode234 node){
        if (node == null) return 0;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (node.data[i] != null)
                count++;
        }
        return count;
    }

    private TreeNode234 findSuccessor(TreeNode234 node, int elementNumber){
        switch (elementNumber){
            case 0:
                if (node.node2 == null) return null;
                return minNode(node.node2);
            case 1:
                if (node.node3 == null) return null;
                return minNode(node.node3);
            case 2:
                if (node.node4 == null) return null;
                return minNode(node.node4);
            default:
                return null;
        }
    }

    private TreeNode234 findPredecessor(TreeNode234 node, int elementNumber){
        switch (elementNumber){
            case 0:
                if (node.node1 == null) return null;
                return maxNode(node.node1);
            case 1:
                if (node.node2 == null) return null;
                return maxNode(node.node2);
            case 2:
                if (node.node3 == null) return null;
                return maxNode(node.node3);
            default:
                return null;
        }
    }

    private void tryRemoveNode(TreeNode234 node){
        if (node.data[0] == null)
            switch (node.nodeNum){
                case 1:
                    node.parent.node1 = null;
                    break;
                case 2:
                    node.parent.node2 = null;
                    break;
                case 3:
                    node.parent.node3 = null;
                    break;
                case 4:
                    node.parent.node4 = null;
                    break;
            }
    }

    private void delete(TreeNode234 node, int value){
        if (node == null || node.data[0] == null) {
            System.out.println("[Tree234 deletion] " + value + " wasn't found!");
            return;
        }
        //0. try to find element in node
        boolean elementFounded = false;
        int elementNum = 0;
        for (int i = 0; i < 3; i++) {
            if (node.data[i] != null && node.data[i] == value){
                elementFounded = true;
                break;
            }
            elementNum++;
        }
        if (elementFounded){
            //2. check if node is leaf;
            if (node.node1 == null && node.node2 == null && node.node3 == null && node.node4 == null ){
                //leaf with searched element in it is guaranteed to be 2-node or 3-node, so we can delete it safely
                node.removeAndShift(elementNum);
                tryRemoveNode(node);
                return; //end of traverse
            } else {
                //3. if node is not a leaf node
                //3.1 find predecessor or successor
                TreeNode234 predecessorNode = findPredecessor(node, elementNum);
                if (predecessorNode != null) {
                    //3.2 swap element and predecessor
                    int predecessorPos = predecessorNode.maxElementPosition();
                    int predecessor = predecessorNode.data[predecessorPos];
                    node.data[elementNum] = predecessor;
                    //3.3 delete predecessor
                    predecessorNode.data[predecessorPos] = null;
                    tryRemoveNode(predecessorNode);
                } else {
                    TreeNode234 successorNode = findSuccessor(node, elementNum);
                    //3.2.1 swap element and successor
                    int successor = successorNode.data[0];
                    node.data[elementNum] = successor;
                    //3.3.1 delete successor
                    successorNode.removeAndShift(0);
                    tryRemoveNode(successorNode);
                }
                return; //end of traverse
            }
        } else { //element was not found
            //4. check if node is 2-node
            int eCount = elementsCount(node);
            if (eCount == 1) {
                //convert 2-node to 3-node for further borrowing possibility
                //4.0 find siblings
                TreeNode234 leftSibling = null;
                TreeNode234 rightSibling = null;
                TreeNode234 parent = node.parent;
                switch (node.nodeNum) {
                    case 1:
                        rightSibling = parent.node2;
                        break;
                    case 2:
                        leftSibling = parent.node1;
                        rightSibling = parent.node3;
                        break;
                    case 3:
                        leftSibling = parent.node2;
                        rightSibling = parent.node4;
                        break;
                    case 4:
                        leftSibling = parent.node3;
                        break;
                }
                int leftSiblingElementsCount = elementsCount(leftSibling);
                int rightSiblingElementsCount = elementsCount(rightSibling);
                //4.1 rotation
                if (leftSibling != null && leftSiblingElementsCount >= 2) {
                    //4.1.1 left rotation
                    int smallestDataParent = parent.remove(0);
                    node.data[eCount] = node.data[0];
                    node.data[0] = smallestDataParent;
                    int highestDataSibling = leftSibling.remove(leftSibling.maxElementPosition());
                    parent.data[0] = highestDataSibling;
                    //shift nodes
                    node.node3 = node.node2;
                    node.node3.nodeNum = 3;
                    node.node2 = node.node1;
                    node.node2.nodeNum = 2;
                    node.node1 = null;
                    //move sibling subtree if exist
                    if (leftSibling.node3 != null && leftSiblingElementsCount == 2) {
                        //case 3-node
                        node.node1 = leftSibling.node3;
                        node.node1.nodeNum = 1;
                        leftSibling.node3 = null;
                        node.node1.parent = node;
                        //case 3-node
                       // node.node3 = leftSibling.node3;
                       // leftSibling.node3 = null;
                      //  node.node3.parent = node;
                    } else
                    if (leftSibling.node4 != null && leftSiblingElementsCount == 3) {
                        //case 4-node
                        node.node1 = leftSibling.node4;
                        leftSibling.node4 = null;
                        node.node1.nodeNum = 1;
                        node.node1.parent = node;
                        //case 4-node
                        //node.node3 = leftSibling.node4;
                        //leftSibling.node4 = null;
                       // node.node3.nodeNum = 3;
                       // node.node3.parent = node;
                    }
                } else
                if (rightSibling != null && rightSiblingElementsCount >= 2) {
                    //4.1.2 right rotation
                    int parentMaxPos = parent.maxElementPosition();
                    int maxDataParent = parent.remove(parentMaxPos);
                    node.data[eCount] = maxDataParent;
                    int smallestRightSibling = rightSibling.removeAndShift(0);
                    parent.data[parentMaxPos] = smallestRightSibling;
                    //move sibling subtree if exist
                    if (rightSibling.node1 != null) {
                        node.node3 = rightSibling.node1;
                        node.node3.nodeNum = 3;
                        node.node3.parent = node;
                        //shift sibling nodes
                        rightSibling.node1 = rightSibling.node2;
                        if (rightSibling.node1 != null)
                            rightSibling.node1.nodeNum = 1;
                        rightSibling.node2 = rightSibling.node3;
                        if (rightSibling.node2 != null)
                            rightSibling.node2.nodeNum = 2;
                        rightSibling.node3 = rightSibling.node4;
                        if (rightSibling.node3 != null)
                            rightSibling.node3.nodeNum = 3;
                        rightSibling.node4 = null;
                    }
                } else
                    //4.2 merge
                    if (leftSibling != null && leftSiblingElementsCount == 1){
                        //4.2.1 merge with left sibling
                        //create new node
                        TreeNode234 mergeNode = new TreeNode234();
                        //insert sibling data to the left
                        mergeNode.data[0] = leftSibling.data[0];
                        mergeNode.node1 = leftSibling.node1;
                        //chose parent data
                        int parentData;
                        switch (node.nodeNum){
                            default:
                            case 2:
                                parentData = parent.removeAndShift(0);
                                break;
                            case 3:
                                parentData = parent.removeAndShift(1);
                                break;
                            case 4:
                                parentData = parent.removeAndShift(2);
                                break;
                        }
                        //insert parent data in the middle
                        mergeNode.data[1] = parentData;
                        mergeNode.node2 = node.node1;
                        if (mergeNode.node2 != null)
                            mergeNode.node2.nodeNum = 2;
                        mergeNode.node3 = node.node2;
                        if (mergeNode.node3 != null)
                            mergeNode.node3.nodeNum = 3;
                        mergeNode.data[2] = node.data[0];
                        //handle relations
                        node.parent = null;
                        switch (node.nodeNum){
                            case 2:
                                parent.node1 = mergeNode;
                                parent.node1.nodeNum = 1;
                                break;
                            case 3:
                                parent.node2 = mergeNode;
                                parent.node2.nodeNum = 2;
                                break;
                            case 4:
                                parent.node3 = mergeNode;
                                parent.node3.nodeNum = 3;
                                break;
                        }
                    } else
                    if (rightSibling != null && rightSiblingElementsCount == 1){
                        //4.2.1 merge with right sibling
                        //create new node
                        TreeNode234 mergeNode = new TreeNode234();
                        //insert sibling data to the right
                        mergeNode.data[2] = rightSibling.data[0];
                        mergeNode.node4 = rightSibling.node2;
                        mergeNode.node4.nodeNum = 4;
                        //chose parent data
                        int parentData;
                        switch (node.nodeNum){
                            default:
                            case 1:
                                parentData = parent.removeAndShift(0);
                                break;
                            case 2:
                                parentData = parent.removeAndShift(1);
                                break;
                            case 3:
                                parentData = parent.removeAndShift(2);
                                break;
                        }
                        //insert parent data in the middle
                        mergeNode.data[1] = parentData;
                        mergeNode.node2 = node.node1;
                        mergeNode.node2.nodeNum = 2;
                        mergeNode.node3 = node.node2;
                        mergeNode.node3.nodeNum = 3;
                        mergeNode.data[0] = node.data[0];
                        //handle relations
                        node.parent = null;
                        switch (node.nodeNum){
                            case 1:
                                parent.node1 = mergeNode;
                                parent.node1.nodeNum = 1;
                                break;
                            case 2:
                                parent.node2 = mergeNode;
                                parent.node2.nodeNum = 2;
                                break;
                            case 3:
                                parent.node3 = mergeNode;
                                parent.node3.nodeNum = 3;
                                break;
                        }
                    } else {
                        int parentElementsCount = elementsCount(node.parent);
                        if (parentElementsCount == 1 && (leftSiblingElementsCount == 1 || rightSiblingElementsCount == 1)) {
                            //4.3 shrink (root-removal)
                            //create new node
                            TreeNode234 mergeNode = new TreeNode234();
                            if (leftSibling != null){
                                mergeNode.data[0] = leftSibling.data[0];
                                mergeNode.data[1] = parent.data[0];
                                mergeNode.data[2] = node.data[0];
                                //handle relations
                                mergeNode.node1 = leftSibling.node1;
                                mergeNode.node2 = leftSibling.node2;
                            } else if (rightSibling != null){
                                mergeNode.data[0] = node.data[0];
                                mergeNode.data[1] = parent.data[0];
                                mergeNode.data[2] = rightSibling.data[0];
                                //handle relations
                                mergeNode.node1 = rightSibling.node1;
                                mergeNode.node2 = rightSibling.node2;
                            }
                            mergeNode.node3 = node.node1;
                            mergeNode.node3.nodeNum = 3;
                            mergeNode.node4 = node.node2;
                            mergeNode.node4.nodeNum = 4;
                            //set new root
                            root.node1 = null;
                            root.node2 = null;
                            mergeNode.parent = null;
                            mergeNode.isRoot = true;
                        }
                    }
            }
        }
        //1. searching for node with element to delete
        if (value < node.data[0])
            delete(node.node1, value); else
        if ((node.data[1] != null && value < node.data[1]) ||
                node.data[1] == null)
            delete(node.node2, value); else
        if (node.data[1] != null &&
                (node.data[2] != null && value > node.data[1] && value < node.data[2]) ||
                (node.data[2] == null && value > node.data[1])
            )
            delete(node.node3, value); else
        if (node.data[2] != null &&
                value > node.data[2])
            delete(node.node4, value);
    }

    @Override
    public void delete(int val) {
        delete(root, val); //begin traverse from the root
    }

    public static void main(String[] args){
        Tree234 tree234 = new Tree234Deletion();
        tree234.insert(1);
        tree234.insert(2);
        tree234.insert(3);
        tree234.insert(4);
        tree234.insert(5);
        tree234.insert(6);
        tree234.insert(7);
        tree234.insert(8);
        tree234.insert(9);
        tree234.insert(10);
        tree234.display();
        tree234.delete(2);
        tree234.display();
        tree234.delete(3);
        tree234.display();
        tree234.delete(6);
        tree234.display();
        tree234.delete(9);
        tree234.display();
        tree234.delete(7);
        tree234.delete(8);
        tree234.display();
        tree234.delete(7);
        tree234.display();
        tree234.delete(4);
        tree234.display();
        tree234.delete(1);
        tree234.display();
        tree234.delete(5);
        tree234.display();
        tree234.delete(10);
        tree234.display();
        tree234.delete(22);
    }

}
