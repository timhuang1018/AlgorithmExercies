package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

/**
 * Given a binary tree where each path going from the root to any leaf form a valid sequence,
 * check if a given string is a valid sequence in such binary tree.
 * We get the given string from the concatenation of an array of integers arr
 * and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
 *
 * 1 <= arr.length <= 5000
 * 0 <= arr[i] <= 9
 * Each node’s value is between [0–9].
 */
public class CheckStringIfValidSequence {


    public boolean hasValidSequence(TreeNode root, int[] arr){
        return dfs(root, arr , 0);
    }

    public boolean dfs(TreeNode node, int[] arr, int index){
        if (node == null || index >= arr.length || node.val != arr[index]){
            return false;
        }

        //checking node depth equal to arr.length
        if (node.left == null && node.right == null && index == arr.length - 1){
            return true;
        }

        boolean left = dfs(node.left, arr, index + 1);
        boolean right = dfs(node.right, arr, index + 1);

        return left || right;
    }


    public static void main(String[] args) {
        CheckStringIfValidSequence solution = new CheckStringIfValidSequence();
        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{0,1,0,0,1,0,null,null,1,0,0});
        System.out.println(solution.hasValidSequence(t1, new int[]{0,1,0,1}));

        TreeNode t2 = TreeNodeGenerator.fromIntegerArray(new Integer[]{0,1,0,0,1,0,null,null,1,0,0});
        System.out.println(solution.hasValidSequence(t2, new int[]{0,0,1}));

        TreeNode t3 = TreeNodeGenerator.fromIntegerArray(new Integer[]{0,1,0,0,1,0,null,null,1,0,0});
        System.out.println(solution.hasValidSequence(t3, new int[]{0,1,1}));

        TreeNode t4 = TreeNodeGenerator.fromIntegerArray(new Integer[]{1});
        System.out.println(solution.hasValidSequence(t4, new int[]{1}));
    }
}
