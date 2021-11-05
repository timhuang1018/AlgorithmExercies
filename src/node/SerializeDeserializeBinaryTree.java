package node;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {


    private final StringBuilder serialString = new StringBuilder();
    static String NONE = "NONE";

    // Encodes a tree to a single string.
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
            serialString.append(NONE);
            serialString.append(',');
        }else{
            serialString.append(node.val);
            serialString.append(',');
            preorderDfs(node.left);
            preorderDfs(node.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        String[] array = data.split(",");
        Queue<String> queue = new LinkedList();
        for(String s : array){
            queue.offer(s);
        }
        return buildTree(queue);
    }

    public TreeNode buildTree(Queue<String> queue){
        String s = queue.poll();
        if(s.equals(NONE)){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.parseInt(s));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }
}
