package bst;

import helper.TreeNode;

public class RecoverBinarySearchTree {

    //original thought is pre-oder, check each node is in max or min value, but the found mistake node's order matter

    //need in-order traversal for BST
    //the order of value should be ascending ->  ex1: 1,2,3,4,5,6
    //comparing the pre and current node
    //if two value swap by mistake, it mean first value got found is smaller, should be the current one
    //if it's second find node, should be the previous one
    //edge case is pre and cur are both invalid in same pair,

    TreeNode firstFind = null;
    TreeNode second = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        inOrderDfs(root);
        int temp = firstFind.val;
        firstFind.val = second.val;
        second.val = temp;
    }

    private void inOrderDfs(TreeNode node){
        if(node == null) return;
        inOrderDfs(node.left);

        if(pre != null && node.val < pre.val){
            //if invalid, pre must be invalid
            if(firstFind == null){
                firstFind = pre;
            }
            //pre is invalid
            //current might or might not be invalid
            //keep the ref, since we are not sure have further candidate
            second = node;
        }

        pre = node;

        inOrderDfs(node.right);
    }
}
