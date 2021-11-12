package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

/**
 * Given two integer arrays inorder and postorder
 * where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree,
 * construct and return the binary tree.
 */
public class ConstructBTfromInorderPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return inorderAndPostorderToTree(inorder, 0, inorder.length -1, postorder, 0, postorder.length -1);
    }

    private TreeNode inorderAndPostorderToTree(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2){
        if (s2 > e2){
            return null;
        }
        //building tree in preorder: self, left, right
        //post order root will be end parameter of the postorder
        TreeNode root = new TreeNode(postorder[e2]);
        //find rootIndex at relative position in inorder array
        int rootIndex = findIndex(inorder, postorder[e2]);
        //index before rootIndex will be left subtree, after will right subtree
        //how to split in postorder array? A: use offset from inorder array
        root.left = inorderAndPostorderToTree(inorder, s1, rootIndex - 1, postorder, s2,  s2 + (rootIndex - 1) - s1);
        root.right = inorderAndPostorderToTree(inorder, rootIndex  + 1, e1, postorder, s2 + (rootIndex) - s1, e2 - 1);

        return root;
    }

    private int findIndex(int[] inorder, int value) {
        for (int index =0; index < inorder.length; index++){
            if (inorder[index] == value){
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ConstructBTfromInorderPostorderTraversal solution = new ConstructBTfromInorderPostorderTraversal();
        TreeNode t1 = solution.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        TreeNodeGenerator.printLevelOrder(t1);
    }
}
