package tree;

import helper.TreeNode;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root).diameter;
    }

    public NodeWrapper dfs(TreeNode node){
        if(node == null){
            return new NodeWrapper(0, 0);
        }

        NodeWrapper left = dfs(node.left);
        NodeWrapper right = dfs(node.right);

        int diameter = Math.max( left.depth + right.depth ,
                Math.max( left.diameter, right.diameter));

        return new NodeWrapper( diameter, Math.max(left.depth, right.depth) + 1);
    }

    static class NodeWrapper{
        int diameter;
        int depth;

        NodeWrapper(int diameter, int depth){
            this.diameter = diameter;
            this.depth = depth;
        }
    }
}
