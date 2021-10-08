package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

/**
 * Given a Binary Tree find the length of the longest path which comprises of nodes with consecutive values in increasing order.
 * Every node is considered as a path of length 1.
 */
public class LongestConsecutiveSequence {

    private int maxLen = 0;
    public int longestCon(TreeNode root){
        preDfs(root, Integer.MIN_VALUE, 1);
        return maxLen;
    }

    public void preDfs(TreeNode node, int parentValue, int length){
        if (node == null) {
            return;
        }
        if (node.val == parentValue + 1){
            length++;
        }else {
            length = 1;
        }
        maxLen = Math.max(maxLen, length);
        parentValue = node.val;

        preDfs(node.left, parentValue, length);
        preDfs(node.right, parentValue, length);
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{6,null,9,7,10,null,null,null,11});
        //expected 3
        System.out.println(solution.longestCon(t1));

        LongestConsecutiveSequence solution2 = new LongestConsecutiveSequence();
        TreeNode t2 = TreeNodeGenerator.fromIntegerArray(new Integer[]{1,2,4,3,null,5,6,null,null,null,null,7});
        //expected 3
        System.out.println(solution2.longestCon(t2));


    }
}
