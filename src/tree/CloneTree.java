package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

public class CloneTree {

    //return a deep copy of the given tree
    static TreeNode cloneTreeDFS(TreeNode root) {
        if(root == null) return null;

        TreeNode left = cloneTreeDFS(root.left);
        TreeNode right = cloneTreeDFS(root.right);

        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = left;
        newRoot.right = right;
        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{1,2,3,4,5});

        System.out.println(t1.printVal());
        System.out.println(t1.printHashcode());
        //expected same value, different object
        System.out.println(cloneTreeDFS(t1).printVal());
        System.out.println(cloneTreeDFS(t1).printHashcode());
    }
}
