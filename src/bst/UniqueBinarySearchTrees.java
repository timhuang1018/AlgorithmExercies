package bst;

/**
 * Given an integer n, return the number of structurally unique
 * BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 */
public class UniqueBinarySearchTrees {

    //firt layer passing root node at each index
    //any value could be place at left,and at right for splitting at the index
    //left sub posibilities * right posibilities
    int[] dp = new int[20];

    public int numTrees(int n) {
        if(n <= 1) return 1;
        if(dp[n]!=0) return dp[n];
        for(int i=1; i<=n; i++){
            //choose each i to be root
            dp[n] += numTrees(i-1) * numTrees( n - i);
        }

        return dp[n];
    }
}
