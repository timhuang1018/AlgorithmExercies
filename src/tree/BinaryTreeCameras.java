package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

/**
 * You are given the root of a binary tree.
 * We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
 *
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 */
//TODO fix , not passing testcase no.3
public class BinaryTreeCameras {


    static int cameras = 0;

    public static int minCameraCover(TreeNode root) {
        if (root.left == null && root.right == null){
            cameras++; //just one node need at least camera
        }else {
            dfsHelper(root);
        }
        return cameras;
    }

    public static int dfsHelper(TreeNode root){
        if(root == null) return 0; //nothing
        if(root.left == null && root.right == null){
            return 1; // a leaf
        }

        int left = dfsHelper(root.left);
        int right = dfsHelper(root.right);

        System.out.println("left:"+left+",right:"+right);
        if(left == 1 || right == 1){
            cameras++;
            return 2; // a parent of leave should put camara
        }else{
            return 1;
        }
    }

    public static void main(String[] args) {
//        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{0,0,null,0,0});
//        //expected 1
//        System.out.println(minCameraCover(t1));

//        TreeNode t2 = TreeNodeGenerator.fromIntegerArray(new Integer[]{0,0,null,0,null,0,null,null,0});
//        //expected 2
//        System.out.println(minCameraCover(t2));

        TreeNode t3 = TreeNodeGenerator.fromIntegerArray(new Integer[]{0,0,null,null,0,0,null,null,0,0});
        //expected 2
        System.out.println(minCameraCover(t3));
    }
}
