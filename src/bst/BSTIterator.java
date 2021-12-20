package bst;

import helper.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    //use iterative in order dfs
    //break outer and inner loop into hasNext() and next() method
    TreeNode cur;
    TreeNode head;
    TreeNode connector;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        cur = root;

        // inOrder(root);
    }


    public int next() {
        // int temp = head.val;
        // head = head.right;
        // return temp;
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int temp = cur.val;
        cur = cur.right;
        return temp;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || cur!= null;
    }


    //original thought
    private void inOrder(TreeNode node){
        if(node == null) return;

        inOrder(node.left);

        if(head == null){
            head = node;
            connector = head;
        }else{
            connector.right = node;
            connector = connector.right;
        }

        inOrder(node.right);

    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
