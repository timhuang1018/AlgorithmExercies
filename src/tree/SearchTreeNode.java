package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

public class SearchTreeNode {
    //Find if node n is in the given tree.
    static boolean search(TreeNode root, TreeNode n) {
        if(root == null) {
            return false;
        }

        boolean left = search(root.left, n);
        boolean right = search(root.right, n);
        return left || right || root == n;
    }

    public static void main(String[] args) {

        TreeNode t1 = TreeNodeGenerator.fromIntArray(new Integer[]{1,2,3,4,5});
        TreeNode n1 = t1.left.left;
        System.out.println(n1);
        //expected true
        System.out.println(search(t1, n1));

        TreeNode n2 = new TreeNode(4);
        //expected false
        System.out.println(search(t1, n2));
    }
}
