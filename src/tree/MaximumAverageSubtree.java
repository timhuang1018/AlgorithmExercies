package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

/**
 * Find out the (sub)tree with the maximum average value.
 * For any tree, its average is the sum of values in the tree over the size of the tree.
 * avg = sum(all values) / count of nodes
 * Return the root of the (sub)tree found.
 *
 * A leaf is NOT a subtree
 */
public class MaximumAverageSubtree {

    static class NodeWrapper{
        int total;
        int count;
        int max;

        public NodeWrapper(int total, int count){
            this.total = total;
            this.count = count;
        }
        public int avg(){
            return total / count;
        }

        @Override
        public String toString() {
            return "NodeWrapper{" +
                    "total=" + total +
                    ", count=" + count +
                    ", max=" + max +
                    '}';
        }
    }

    public static int maxAvg(TreeNode root){
        return wrapNodes(root).max;
    }

    public static NodeWrapper wrapNodes(TreeNode node){
        if (node == null){
            return new NodeWrapper(0, 0);
        }
        if (node.left == null && node.right == null){
            return new NodeWrapper(node.val, 1); // leaf not calculating max
        }
        NodeWrapper wrapperLeft = wrapNodes(node.left);
        NodeWrapper wrapperRight = wrapNodes(node.right);

        NodeWrapper result = new NodeWrapper(
                wrapperLeft.total + wrapperRight.total + node.val,
                wrapperLeft.count + wrapperRight.count + 1);

        result.max =  Math.max(result.avg(),Math.max(wrapperLeft.max, wrapperRight.max));
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{6,2,11,-4,1,-3,-2,null,null,null,null,3,1});
        System.out.println(maxAvg(t1));
    }
}
