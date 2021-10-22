package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a binary tree where node values are digits from 1 to 9.
 * A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
 *
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 */
public class PseudoPalindromicPath {

    int result = 0;

    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> set = new HashSet<>();
        countPal(root, set);
        return result;
    }

    public void countPal(TreeNode node, Set<Integer> pairContainer){
        if( node == null ){
            return;
        }
        updatePair(node.val, pairContainer);

        //reach leave
        if( node.left == null && node.right == null && pairContainer.size()<=1){
            result++;
            updatePair(node.val, pairContainer);
            return;
        }
        countPal(node.left, pairContainer);
        countPal(node.right, pairContainer);
        updatePair(node.val, pairContainer);

    }

    private void updatePair(int value, Set<Integer> pairContainer) {
        if(pairContainer.contains(value)){
            pairContainer.remove(value);
        }else{
            pairContainer.add(value);
        }
    }

    public static void main(String[] args) {
        PseudoPalindromicPath solution = new PseudoPalindromicPath();
        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{2,3,1,3,1,null,1});
        int result = solution.pseudoPalindromicPaths(t1);
        System.out.println(result);

        PseudoPalindromicPath solution2 = new PseudoPalindromicPath();
        TreeNode t2 = TreeNodeGenerator.fromIntegerArray(new Integer[]{2,1,1,1,3,null,null,null,null,null,1});
        int result2 = solution2.pseudoPalindromicPaths(t2);
        System.out.println(result2);
    }
}
