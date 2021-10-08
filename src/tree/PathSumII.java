package tree;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 * A root-to-leaf path is a path starting from the root and ending at any leaf node.
 * A leaf is a node with no children.
 *
 * Example 1:
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 * Example 2:
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 */
public class PathSumII {

    public int targetSum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        this.targetSum = targetSum;
        List<Integer> temp = new ArrayList<>();
        dfs(root, targetSum, temp, result);
        return result;
    }

    public void dfs(TreeNode node, int remain, List<Integer> temp, List<List<Integer>> result){
        if (node == null){
            return;
        }

        temp.add(node.val);

        if (node.left == null && node.right == null && node.val == remain){
            List<Integer> copy = new ArrayList<>(temp);
            result.add(copy);
        }

        dfs(node.left, remain - node.val, temp, result);
        dfs(node.right, remain - node.val, temp, result);

        temp.remove(temp.size()-1);
    }
}
