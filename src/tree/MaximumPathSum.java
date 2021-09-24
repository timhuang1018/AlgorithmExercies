package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

public class MaximumPathSum {

    //TODO not sure the solution is correct
    //Get the depth of the binary tree
    public static int dfs(TreeNode root) {
        //base case,
         if(root==null) {
             return 1;
         }

        int left = dfs(root.left);
        int right = dfs(root.right);
        return left + right + 1;
    }

    public static void main(String[] args) {
        //use value as path id
        TreeNode t1 = TreeNodeGenerator.fromIntArray(new Integer[]{1,2,3,4,5,6,7,null,null,null,null,8,9});
        //expected 1+3+6+9 = 19
        System.out.println(dfs(t1));

        //expected 1+3+7+10 = 21
        TreeNode t2 = TreeNodeGenerator.fromIntArray(new Integer[]{1,2,3,4,5,6,7,null,null,null,null,8,9,10});
        System.out.println(dfs(t2));
    }
}
