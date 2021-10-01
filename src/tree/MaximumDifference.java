package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

/**
 * Find the maximum difference between an ancestor node and any of its descendant node,
 * where (ancestor.value - descendant.value) is the maximum.
 */
public class MaximumDifference {

    int max = 0;

    public int maxDifference(TreeNode root){
        dfs(root);
        return max;
    }

    //check every ancestor with smallest descendant
    public int dfs(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int smaller = Math.min(left, right);
        max = Math.max(max, node.val - smaller);
        return Math.min(node.val, smaller); //only return the smallest
    }

    public static void main(String[] args) {
        MaximumDifference solution = new MaximumDifference();

        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{6,2,11,-4,1,3,-2,null,null,null,null,-3,1});
        //expected 14
        System.out.println(solution.maxDifference(t1));
    }
}
