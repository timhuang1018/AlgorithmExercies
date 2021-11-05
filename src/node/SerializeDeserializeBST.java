package node;

import helper.TreeNode;
import helper.TreeNodeGenerator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 */
public class SerializeDeserializeBST {

    private final StringBuilder serialString = new StringBuilder();
    // Encodes a tree to a single string.
    //use preorder order to make a int array
    public String serialize(TreeNode root) {
        preorderDfs(root);
        //remove last coma (redundant)
        if(serialString.length() > 0){
            serialString.deleteCharAt(serialString.length() -1);
        }
        return serialString.toString();
    }

    private void preorderDfs(TreeNode node){
        if(node == null){
            return;
        }

        serialString.append(node.val);
        //add a coma as separator
        serialString.append(',');
        preorderDfs(node.left);

        preorderDfs(node.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println("for deserialize string"+data);
        if(data == null || data.length() == 0){
            return null;
        }
        String[] list = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for (String s : list){
            queue.offer(Integer.parseInt(s));
        }

        return splitQueue(queue);
    }

    public TreeNode splitQueue(Queue<Integer> queue){
        if(queue == null || queue.isEmpty()){
            return null;
        }

        TreeNode current = new TreeNode(queue.poll());
        Queue<Integer> leftQueue = new LinkedList<>();

        while (!queue.isEmpty() && current.val > queue.peek()){
            leftQueue.offer(queue.poll());
        }

        current.left = splitQueue(leftQueue);
        current.right = splitQueue(queue);

        return current;
    }

    public static void main(String[] args) {
        SerializeDeserializeBST solution = new SerializeDeserializeBST();
        String serialString = solution.serialize(TreeNodeGenerator.fromIntegerArray(new Integer[]{2,1,3}));
        System.out.println(serialString);
        TreeNode deserialResult = solution.deserialize(serialString);
        System.out.println(deserialResult.printVal());

        SerializeDeserializeBST solution2 = new SerializeDeserializeBST();
        String serialString2 = solution2.serialize(TreeNodeGenerator.fromIntegerArray(new Integer[]{1,null,2}));
        System.out.println(serialString2);
        TreeNode deserialResult2 = solution.deserialize(serialString2);
        System.out.println(deserialResult2.printVal());

    }
}
