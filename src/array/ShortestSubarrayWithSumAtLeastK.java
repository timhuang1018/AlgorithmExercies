package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {

    public static int shortestSubarray(int[] nums, int k) {
        long[] prefixSum = new long[nums.length+1];
        for (int i=0; i<nums.length; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int minLen = Integer.MAX_VALUE, index = 0;

        while (index < prefixSum.length){
            while (!deque.isEmpty() && prefixSum[deque.peekLast()]>= prefixSum[index]){
                deque.pollLast();
            }
            while (!deque.isEmpty() && prefixSum[index]-prefixSum[deque.peekFirst()] >= k ){
                minLen = Math.min(minLen, index - deque.pollFirst());
            }
            deque.addLast(index++);
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    //brute force
    //Time Limit Exceeded

    public int shortestSubarray2(int[] A, int K) {
        int[] presum = new int[A.length+1];
        int res = A.length+1;
        for(int i=1;i<presum.length;i++){
            presum[i] = presum[i-1]+A[i-1];
            for(int j=i-1;j>=0;j--){
                if(presum[i]-presum[j]>=K)
                    res = Math.min(res, i-j);
            }
        }
        return res == (A.length+1)?-1: res;
    }

    //pre fix sum [0,1,2,3,4,10,7,4,5,14,16,....... ], K=11
    //outer loop add new sum sequence
    //inner loop do:
    //1.find smaller than previous help, remove worse candidates
    //2.left a increasing queue, see if we can find shorter


    public static void main(String[] args) {

        //expected 1
        System.out.println(shortestSubarray(new int[]{1},1));
    }
}
