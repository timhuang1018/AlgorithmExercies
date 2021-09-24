package tree;

import helper.TreeNode;

public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        //definitely have one node
        return isUnivalTree(root, root.val);
    }

    public boolean isUnivalTree(TreeNode node, int val){
        if(node == null){
            return true;
        }
        return node.val == val
                && isUnivalTree(node.left, val)
                && isUnivalTree(node.right, val);
    }
}
