package helper;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeGenerator {

    public static TreeNode fromIntArray(Integer[] array) {
        if (array == null || array.length == 0) return null;
        int i = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[i++]);
        queue.offer(root);

        while (i < array.length && !queue.isEmpty()) {
            TreeNode node = queue.poll();

            Integer value = array[i++];
            if (value!=null){
                TreeNode left = new TreeNode(value);
                node.left = left;
                queue.offer(left);
            }

            if (i >= array.length){
                break;
            }

            value = array[i++];
            if (value!=null){
                TreeNode right = new TreeNode(value);
                node.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}
