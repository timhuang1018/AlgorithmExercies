package greedy;

public class BestTimeBuyStockII {

    public static int maxProfit(int[] prices) {

        int profit = 0;
        int hold = -1;
        int last = prices.length-1;
        for (int i=0;i<last;i++){

            if (hold==-1 && prices[i]<prices[i+1]){
                hold = prices[i];
            }else if(hold>=0 && prices[i]>hold && prices[i]>prices[i+1]){
                profit += (prices[i] - hold);
                hold = -1;
            }
        }
        if (hold>=0 && prices[last]>hold){
            profit += (prices[last] - hold);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] t1 = new int[]{7,1,5,3,6,4};
        //expected 7
        System.out.println(maxProfit(t1));

        int[] t2 = new int[]{1,2,3,4,5};
        //expected 4
        System.out.println(maxProfit(t2));
        int[] t3 = new int[]{2,1,2,0,1};
        //expected 2
        System.out.println(maxProfit(t3));
    }
}
