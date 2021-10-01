package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

/**
 * Find out the length of the longest increasing path (from top to bottom) in the given tree.
 * (Hint: search for the longest decreasing path from bottom to top instead)
 */
public class LongestIncreasingPath {

    //return length of the path
    public int maxIncreasingPath(TreeNode root){
        return dfs(root).max;
    }

    public NodeWrapper dfs(TreeNode node){
        if (node == null){
            return new NodeWrapper( 0);
        }

        NodeWrapper left = dfs(node.left);
        NodeWrapper right = dfs(node.right);

        NodeWrapper nw = new NodeWrapper(node.val);

        //find longer length and check if it's valid
        if (left.length >= right.length && left.previousVal > node.val){
            nw.length = left.length + 1;
            nw.max = Math.max(nw.length, right.length);
        }else if (right.length >= left.length && right.previousVal > node.val){
            nw.length = right.length + 1;
            nw.max = Math.max(nw.length, left.length);
        }else {
            nw.length = 1;
            nw.max = Math.max(1, Math.max(left.max, right.max));
        }

        System.out.println("left:"+left+",right:"+right+", nw:"+nw);

        return nw;
    }


    static class NodeWrapper{
        int length;
        int previousVal;
        int max;
        public NodeWrapper(int previousVal){
            this.previousVal = previousVal;
        }

        @Override
        public String toString() {
            return "NodeWrapper{" +
                    "length=" + length +
                    ", previousVal=" + previousVal +
                    ", max=" + max +
                    '}';
        }
    }

    public static void main(String[] args) {
        LongestIncreasingPath solution = new LongestIncreasingPath();

        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{6,0,3,4,1,6,4,5,null,7,null,8,5,null,null,3,0,null,9,null,null,null,7,null,null,null,null,null,8});
        //expected 4
        System.out.println(solution.maxIncreasingPath(t1));
    }
}
