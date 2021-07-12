package array;

public class SortedSquare {
    public int[] sortedSquares(int[] nums) {
        if (nums.length<=0) return nums;
        int [] result = new int[nums.length];
        int i=0, j = nums.length-1, k = nums.length-1;
        while (k>=0){
            if (Math.abs(nums[i])<=Math.abs(nums[j])){
                result[k] = nums[j] * nums[j];
                j--;
            }else {
                result[k] = nums[i] * nums[i];
                i++;
            }
            k--;
        }
        return result;
    }
}
