package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

public class SearchTreeNodeII {

    //Find if either node n or node m is in the given tree.
    static boolean search(TreeNode root, TreeNode n, TreeNode m) {

        if (root == null){
            return false;
        }

        boolean left = search(root.left, n, m);
        boolean right = search(root.right, n, m);

        return left || right || (root == n || root == m);
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNodeGenerator.fromIntArray(new Integer[]{1,2,3,4,5});
        TreeNode n = new TreeNode(2);
        TreeNode m = t1.left.right;

        //expected true
        System.out.println(search(t1 ,n ,m));
    }
}
