package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

/**
 * You are given the root of a binary tree.
 * We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
 *
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 */
public class BinaryTreeCameras {


    int camera = 0;

    public int minCameraCover(TreeNode root) {
        int result = postDfs(root);
        if(result <= 1){
            camera++;
        }
        return camera;
    }

    public int postDfs(TreeNode root){
        if(root == null) return 0; //nothing
        if(root.left == null && root.right == null){
            return 1; // 1 represent of no monitoring , ex. a leave
        }

        int left = postDfs(root.left);
        int right = postDfs(root.right);


        if(left == 1 || right == 1){ // a parent of no monitoring should put camara
            camera++;
            return 3; //3 represent of camera
        }else if (left == 3 || right == 3){
            return 2; //2 represent of monitoring by camera
        }else{
            return 1; //child may be 2 or 0 , should be value of no monitoring
        }
    }

    public static void main(String[] args) {
        BinaryTreeCameras solution = new BinaryTreeCameras();
        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{0,0,null,0,0});
        //expected 1
        System.out.println(solution.minCameraCover(t1));

        BinaryTreeCameras solution2 = new BinaryTreeCameras();
        TreeNode t2 = TreeNodeGenerator.fromIntegerArray(new Integer[]{0,0,null,0,null,0,null,null,0});
        //expected 2
        System.out.println(solution2.minCameraCover(t2));

        BinaryTreeCameras solution3 = new BinaryTreeCameras();
        TreeNode t3 = TreeNodeGenerator.fromIntegerArray(new Integer[]{0,0,null,null,0,0,null,null,0,0});
        //expected 2
        System.out.println(solution3.minCameraCover(t3));
    }
}
