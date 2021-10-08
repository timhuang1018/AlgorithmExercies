package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any path.
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 */
public class BinaryTreeMaximumPathSum {

    //left
    //right
    //record the max by left and right and self , and any of the side
    // return the bigger path
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postDfs(root);
        return maxPath;
    }

    public int postDfs(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = postDfs(node.left);
        int right = postDfs(node.right);

        int tempMax = Math.max(left + node.val, right + node.val);
        tempMax = Math.max(tempMax, left + right + node.val);
        //if left and child both negative
        tempMax = Math.max(tempMax, node.val);

        maxPath = Math.max(maxPath, tempMax);

        //give up child path sum if both are negative
        if (left < 0 && right < 0) return  node.val;
        return left > right ? left + node.val : right + node.val;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();
        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{-3});

        //expected -3
        System.out.println(solution.maxPathSum(t1));

        BinaryTreeMaximumPathSum solution2 = new BinaryTreeMaximumPathSum();
        TreeNode t2 = TreeNodeGenerator.fromIntegerArray(new Integer[]{2,-1});

        //expected 2
        System.out.println(solution2.maxPathSum(t2));

        BinaryTreeMaximumPathSum solution3 = new BinaryTreeMaximumPathSum();
        TreeNode t3 = TreeNodeGenerator.fromIntegerArray(new Integer[]{9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6});
        //expected 16
        System.out.println(solution3.maxPathSum(t3));
    }
}
