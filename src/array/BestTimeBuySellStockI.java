package array;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0
 */
public class BestTimeBuySellStockI {

    //record the day which rate start to climb as buying day
    //record the day which rate start to fall as selling day
    //store value when everytime sufselling
    public static int singleTransaction(int[] prices){
        if (prices.length<=1) return 0;

        int maxProfit = 0, buyPrice = prices[0]; //0 means not buying yet

        for (int i=1; i<prices.length; i++){

            if (prices[i]>buyPrice){
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            }

            buyPrice = Math.min(buyPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        //expected 5
        System.out.println(singleTransaction(new int[]{7,1,5,3,6,4}));
    }
}
