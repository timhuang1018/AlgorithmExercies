package bst;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeToGreaterSumTree {

    //traverse through a in-order dfs, and keep node by a arrray
    //go from end backward (biggest value) increment each node.val
    public TreeNode bstToGst(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        inOrderDfs(root, list);

        int sum = 0;
        for(int i= list.size()-1; i>=0; i--){
            int temp = list.get(i).val;
            list.get(i).val += sum;
            sum += temp;
        }

        return root;
    }

    private void inOrderDfs(TreeNode node, List<TreeNode> list){
        if(node == null) return;
        inOrderDfs(node.left, list);

        list.add(node);

        inOrderDfs(node.right, list);

    }
}
