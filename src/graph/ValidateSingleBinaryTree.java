package graph;

import helper.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateSingleBinaryTree {

    //to be a valid binary tree
    //1.every node should appear just once -> only be child once
    //2.need to connect all nodes -> find the top, able to visit all
    public boolean isBinaryTree(List<TreeNode> nodes) {
        if (nodes == null || nodes.size() == 0){
            return false;
        }
        Set<TreeNode> childSet = new HashSet<>();
        TreeNode root = nodes.get(0);
        childSet.add(root);

        for (TreeNode node : nodes){
            if (node.left!=null){
                if (childSet.contains(node.left)){
                    return false;
                }else {
                    childSet.add(node.left);
                }
                if (root == node.left){
                    root = node;
                }
            }
            if (node.right!=null){
                if (childSet.contains(node.right)){
                    return false;
                }else {
                    childSet.add(node.right);
                }
                if (root == node.right){
                    root = node;
                }
            }
        }

        return findTreeSize(root) == nodes.size();
    }

    public int findTreeSize(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = findTreeSize(node.left);
        int right = findTreeSize(node.right);

        return left + right + 1;
    }


    public static void main(String[] args) {
        ValidateSingleBinaryTree solution = new ValidateSingleBinaryTree();
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//
//        n1.left = n2;
//        n1.right = n3;
//        n3.left = n4;
//        //expected true
//        System.out.println(solution.isBinaryTree(Arrays.asList(n4,n2,n3,n1)));

//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//
//        n1.left = n2;
//        n1.right = n3;
//        n2.right = n4;
//        n3.left = n4;
//        //expected false
//        System.out.println(solution.isBinaryTree(Arrays.asList(n4,n2,n3,n1)));


//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//
//        n1.left = n2;
//        n2.left = n1;
//        //expected false
//        System.out.println(solution.isBinaryTree(Arrays.asList(n2,n1)));

//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(5);
//        TreeNode n6 = new TreeNode(6);
//
//        n1.left = n2;
//        n1.right = n3;
//
//        n4.left = n5;
//        n4.right = n6;
//        //expected false
//        System.out.println(solution.isBinaryTree(Arrays.asList(n2, n6, n4, n1, n3, n5)));


        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;

        //expected false
        System.out.println(solution.isBinaryTree(Arrays.asList(n2,n3,n1)));

    }
}
