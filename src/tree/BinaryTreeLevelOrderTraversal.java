package tree;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> result = new ArrayList();
        if(root == null){
            return result;
        }
        queue.offer(root);

        while(true){

            List<Integer> temp = new ArrayList();
            Queue<TreeNode> tempQueue = new LinkedList();
            while(!queue.isEmpty()){

                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null){
                    tempQueue.offer(node.left);
                }
                if(node.right != null){
                    tempQueue.offer(node.right);
                }
            }

            result.add(temp);
            if(tempQueue.isEmpty()){
                break;
            }else{
                while(!tempQueue.isEmpty()){
                    queue.offer(tempQueue.poll());
                }
            }
        }
        return result;
    }
}
