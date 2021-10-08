package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */
public class LowestCommonAncestorOfBinaryTree {

    TreeNode result;

    //TODO use return node as found node

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    public int dfs(TreeNode node,  TreeNode p, TreeNode q){
        if (node == null){
            return 0;
        }
        int left = dfs(node.left, p, q);
        int right = dfs(node.right, p, q);
        if (left + right == 2){
            result = node;
            return 0; //reset to prevent for modifying the answer
        }

        boolean hasAnother = node.val ==p.val || node.val == q.val;
        if (hasAnother && left + right == 1){
            result = node;
            return 0; //reset to prevent for modifying the answer
        }
        return left + right + (hasAnother? 1 : 0);
    }

    public static class NodeWrapper{
        TreeNode node;
        boolean hasFound;  // indicate if any of the two is found
        public NodeWrapper(TreeNode node, boolean hasFound){
            this.node = node;
            this.hasFound = hasFound;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfBinaryTree solution = new LowestCommonAncestorOfBinaryTree();

        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        System.out.println(solution.lowestCommonAncestor(t1, new TreeNode(5), new TreeNode(1)));
    }

}
