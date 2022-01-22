package dp;

/**
 * The Tribonacci sequence Tn is defined as follows:
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * Given n, return the value of Tn.
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 *
 * Input: n = 25
 * Output: 1389537
 *
 * Constraints:
 *
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
public class NthTribonacciNumber {

    int[] dp;
    public int tribonacci(int n) {
        if(n<=1) return n;
        if(n==2) return 1;
        if(dp == null){
            dp = new int[n + 1];
        }else if(dp[n] > 0){
            return dp[n];
        }

        dp[n] = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);

        return dp[n];
    }
}
