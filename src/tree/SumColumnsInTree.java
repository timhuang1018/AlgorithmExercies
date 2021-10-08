package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the sum of each column of tree nodes in a binary tree
 */
public class SumColumnsInTree {

    int right = 0;
    int left = 0;

    //list each column in order
    public List<Integer> columnSum(TreeNode root){
        findBoundary(root, 0);

        //start from the middle point
        //+ 1 for end to end , - 1 in case is even number when divide by 2
        Integer[] result = preDfs(root, new Integer[right - left + 1], (right - left + 1 - 1)/2);
        return Arrays.asList(result);
    }

    private Integer[] preDfs(TreeNode node, Integer[] list, int x) {
        if (node == null){
            return list;
        }

        if (list[x]==null){
            list[x] = node.val;
        }else {
            list[x] +=  node.val;
        }

        preDfs(node.left, list, x - 1);
        preDfs(node.right, list, x + 1);

        return list;
    }


    //recursively update both end to find the boundary
    public void findBoundary(TreeNode node, int x){
        if (node == null){
            return;
        }

        findBoundary(node.left, x - 1);
        findBoundary(node.left, x + 1);

        if (right < x){
            right = x;
        }
        if (left > x){
            left = x;
        }
    }

    public static void main(String[] args) {

        SumColumnsInTree solution = new SumColumnsInTree();
        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{2,7,5,2,6,null,9,null,null,5,11,4});

        System.out.println(solution.columnSum(t1));
    }
}
