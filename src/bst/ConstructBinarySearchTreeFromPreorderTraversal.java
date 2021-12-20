package bst;

import helper.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {

    //preorder will go self , left , right
    //use current value to form node from each index
    //pass root with first index
    //recursive check if next index value is smaller or greater with boundary


    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] preorder, int bound){
        if(index >= preorder.length || preorder[index] >= bound) return null;

        TreeNode root = new TreeNode(preorder[index++]);
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, bound);
        return root;
    }

    //original thought, do check before creating child
    //it's better to return child TreeNode then we can check uniformly at base case
    public TreeNode bstFromPreorder2(int[] preorder) {
        TreeNode root = new TreeNode(preorder[index++]);
        preDfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE, preorder);
        return root;
    }

    public void preDfs(TreeNode node, int max, int min, int[] preorder){
        if(index >= preorder.length) return;
        if(preorder[index] <= node.val && preorder[index] >= min){
            TreeNode left = new TreeNode(preorder[index++]);
            node.left = left;
            preDfs(left, node.val, min, preorder);
        }

        if(index < preorder.length  && preorder[index] >= node.val && preorder[index] <= max){
            TreeNode right = new TreeNode(preorder[index++]);
            node.right = right;
            preDfs(right, max, node.val, preorder);
        }
    }

    public static void main(String[] args) {
        ConstructBinarySearchTreeFromPreorderTraversal solution = new ConstructBinarySearchTreeFromPreorderTraversal();

//        solution.bstFromPreorder(new int[]{8,5,1,7,10,12});
        solution.bstFromPreorder(new int[]{4,2});
    }
}
