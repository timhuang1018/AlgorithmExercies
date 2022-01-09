package tree;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the maximum width of the given tree.
 *
 * The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
 * where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * It is guaranteed that the answer will in the range of 32-bit signed integer.
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 *
 * Input: root = [1,3,null,5,3]
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 */
public class MaximumWidthOfBinaryTree {

    //use queue to store node and its column (wrapper class)
    //every node check its left and right child, put into queue if exist
    //where the null nodes between the end-nodes are also counted into the length calculation.
    //this means every level's width will multiply 2 by parent
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 1;
        Queue<Wrapper> queue = new LinkedList<>();
        queue.add(new Wrapper(root, 1));

        while(!queue.isEmpty()){

            Queue<Wrapper> temp = new LinkedList<>();
            Integer left = null;
            while(!queue.isEmpty()){
                Wrapper wp = queue.poll();
                if(left == null){
                    left = wp.column;
                }else{
                    maxWidth = Math.max(maxWidth, wp.column - left + 1);
                }
                if(wp.node.left != null){
                    temp.offer(new Wrapper(wp.node.left, wp.column * 2));
                }
                if(wp.node.right != null){
                    temp.offer(new Wrapper(wp.node.right, wp.column * 2 + 1));
                }
            }

            queue.addAll(temp);

        }

        return maxWidth;
    }

    static class Wrapper{
        TreeNode node;
        int column;
        public Wrapper(TreeNode node, int column){
            this.node = node;
            this.column = column;
        }

        @Override
        public String toString(){
            return "Wrapper{" +
                    "node=" + node.val +
                    ", column=" + column +
                    '}';
        }
    }
}
