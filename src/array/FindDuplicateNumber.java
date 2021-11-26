package array;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class FindDuplicateNumber {

    //TODO optimized by using cycle detection

    //find mid number of nums(range: 1 ~ n), have n + 1 integers
    //mean if mid is 5 , range 1 ~ 10
    //count in array which number is at range 1 ~ 5
    //count should be 5 but if it's bigger, duplicate happen at range 1 ~ 5
    //duplicate happen at range 6 ~ 10 in other hand
    public static int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int count = 0;
            for(int number : nums){
                if(number <= mid){
                    count++;
                }
            }
            if(count<=mid){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        //expected 2
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }
}
