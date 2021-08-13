package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * You are given an array of integers nums,
 * there is a sliding window of size k
 * which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 */
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int numberOfComb = nums.length - k + 1;
        int[] result = new int[numberOfComb];
        Deque<NumberWrapper> deque = new ArrayDeque<>();
        int left = 0, right = 0;

        while (right<nums.length){

            //leaving
            if (right-left == k){
                NumberWrapper nw = deque.peekLast();
                result[left] = nw.number;
                if (nw.index==left){
                    deque.pollLast();
                }
                left++;
            }
            //joining
            int now = nums[right];
            while (!deque.isEmpty() && deque.peek().number<now){
                deque.pop();
            }
            deque.push(new NumberWrapper(now,right));

            right++;
        }

        NumberWrapper nw = deque.peekLast();
        result[left] = nw.number;
        return result;
    }

    public static class NumberWrapper{
        public NumberWrapper(int number,int index){
            this.number = number;
            this.index = index;
        }

        @Override
        public String toString() {
            return "NumberWrapper{" +
                    "number=" + number +
                    ", index=" + index +
                    '}';
        }

        int number;
        int index;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
//        int k =3;
//        maxSlidingWindow(nums,k);

        int[] nums = new int[]{7,2,4};
        int k =2;
        //expected [7,4]
        maxSlidingWindow(nums,k);
    }
}
