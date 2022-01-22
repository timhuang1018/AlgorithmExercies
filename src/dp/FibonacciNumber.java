package dp;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 */
public class FibonacciNumber {

    int[] dp;

    public int fib(int n) {
        if(dp == null){
            dp = new int[n+1];
        }
        if(dp[n] > 0){
            return dp[n];
        }

        if(n == 0) return 0;
        if(n == 1) return 1;
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("a".substring(0,0));
    }
}
