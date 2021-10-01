package helper;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeGenerator {

    public static TreeNode fromIntegerArray(Integer[] array) {
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
        printGraph(root);
        return root;
    }

    private static void printGraph(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int space = 1;
        while (!queue.isEmpty()){
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                System.out.print(node.val);

                int count = 0;
                while (count <space){
                    System.out.print(" ");
                    count++;
                }
                if(node.left != null){
                   temp.offer(node.left);
                }
                if (node.right != null){
                    temp.offer(node.right);
                }
            }

            while (!temp.isEmpty()){
                queue.offer(temp.poll());
            }
            System.out.println("");
            space++;
        }

    }

    public static TreeNode buildTree(Integer[] arr) {
        TreeNode root = null;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode t = arr[i] == null ? null : new TreeNode(arr[i]);
        root = t;
        q.add(root);
        i++;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode t1 = q.poll();
            if (t1 != null) {
                t1.left = arr[i] == null ? null : new TreeNode(arr[i]);
                q.add(t1.left);
                i++;
                if (i >= arr.length) {
                    break;
                }
                t1.right = arr[i] == null ? null : new TreeNode(arr[i]);
                q.add(t1.right);
                i++;
            }
        }
        printLevelOrder(root);
        return root;
    }

    private static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            sb.append(t == null ? "null" : t.val).append(", ");
            if (t != null) {
                q.add(t.left);
                q.add(t.right);
            }
        }
        System.out.println(sb.toString());
    }
}
