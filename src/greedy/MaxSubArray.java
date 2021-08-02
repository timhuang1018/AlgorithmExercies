package greedy;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums.length==1) return nums[0];
        int max = nums[0];
        int temp = nums[0];
        for (int i=1; i<nums.length; i++){
            if(temp + nums[i] <= nums[i]){
                temp = nums[i];
            }else {
                temp += nums[i];
            }
            max = Math.max(max,temp);
        }
        return max;
    }
}
