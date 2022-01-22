package dp;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 *
 *
 * Example 1:
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 *
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 *
 *
 * Constraints:
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */

public class MinCostClimbingStairs {

    //constraint make sure the value integer won't overflow
    //1,2 step each stair
    //cost at 2 will be it selft + cost(i-1) + cost(i-2)
    //min cost at index 0, and 1 is fixed(use original value so it is min)
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        //cost.length - 1 is last step, but cost.length - 2 also acceptable (at this step also can terminate)
        //so find min between the these two
        return Math.min(findMinCost(cost, dp, cost.length - 1), findMinCost(cost, dp, cost.length - 2));
    }

    private int findMinCost(int[] cost, int[] dp, int stairIndex){
        if(stairIndex < 0){
            return 0;
        }else if(dp[stairIndex]>0){
            return dp[stairIndex];
        }else{
            dp[stairIndex] =  cost[stairIndex] + Math.min(findMinCost(cost, dp, stairIndex - 1), findMinCost(cost, dp, stairIndex - 2));
            return dp[stairIndex];
        }
    }
}
