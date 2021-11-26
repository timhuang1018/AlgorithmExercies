package array;

import helper.DataLogger;

public class SortColors {


    //use three pointer, start, end and one visit each cell
    //to make partition into three part in one pass
    //time O(n) space O(1)

    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;


    public static void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;

        int start = 0, swapIndex =0, end = nums.length - 1;

        while(swapIndex <= end){
            if(nums[swapIndex] == RED){
                swap(nums, start, swapIndex);
                start++;
                swapIndex++;
            }else if(nums[swapIndex] == BLUE){
                swap(nums, end, swapIndex);
                end--;
            }else if(nums[swapIndex] == WHITE){
                swapIndex++;
            }
        }

        DataLogger.printIntArray(nums);
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }
}
