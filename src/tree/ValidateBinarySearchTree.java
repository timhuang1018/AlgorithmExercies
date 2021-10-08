package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Input: root = [2,1,3]
 * Output: true
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return preDfs(root, null, null);
    }

    public boolean preDfs(TreeNode node, Integer min, Integer max){
        if( node == null){
            return true;
        }

        if((min != null && node.val <= min) || (max !=null && node.val >= max)){
            return false;
        }

        boolean left = preDfs(node.left, min, node.val);
        boolean right = preDfs(node.right, node.val, max);
        return left && right;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{5,1,4,null,null,3,6});
        //expected false
        System.out.println(solution.isValidBST(t1));

        ValidateBinarySearchTree solution2 = new ValidateBinarySearchTree();
        TreeNode t2 = TreeNodeGenerator.fromIntegerArray(new Integer[]{2,2,2});
        //expected false
        System.out.println(solution2.isValidBST(t2));

        TreeNode t3 = TreeNodeGenerator.fromIntegerArray(new Integer[]{Integer.MAX_VALUE});
        //expected true
        System.out.println(solution2.isValidBST(t3));
    }
}
