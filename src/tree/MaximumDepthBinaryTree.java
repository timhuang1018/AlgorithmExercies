package tree;

import helper.TreeNode;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 */
public class MaximumDepthBinaryTree {


    //post-order
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return maxDepth(root.left) + maxDepth(root.right) + 1;
    }


    //original
    //recursive by pre-order
    //need extra input variable
    public int maxDepth2(TreeNode root) {
        return maxDepthHelper(root, 0);
    }

    public int maxDepthHelper(TreeNode node, int level){
        if(node == null) return level;
        return Math.max(maxDepthHelper(node.left, level+1), maxDepthHelper(node.right, level + 1));
    }

}
