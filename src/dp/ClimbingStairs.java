package dp;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class ClimbingStairs {

    //Fibonacci type question could use three variable to circularly accumulate to get answer
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int at2step = 1;
        int at1step = 2;
        int total = 0;

        for(int i=2; i<n; i++){
            total = at2step + at1step;
            at2step = at1step;
            at1step = total;
        }

        return total;
    }


    public int climbStairs1(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i =3; i<=n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int climbStairs2(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i =3; i<=n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    int[] dp;

    public int climbStairs3(int n) {
        dp = new int[n+1];
        return climb(0, n);
    }

    private int climb(int i, int n){
        if(i > n){
            return 0;
        }
        if(i == n){
            return 1;
        }
        if(dp[i] > 0){
            return dp[i];
        }

        dp[i] = climb(i+1, n) + climb(i+2, n);

        return dp[i];
    }
}
