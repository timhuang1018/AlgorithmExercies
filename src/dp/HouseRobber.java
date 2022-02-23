package dp;

/**
 * You are a professional robber planning to rob houses along a street.Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        // if(nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        // int[] dp = new int[nums.length];
        //either start from index 0 or 1
        int first = nums[0];
        int second = Math.max(nums[1], nums[0]);
        int total = Math.max(first, second);
        for(int i=2; i < nums.length; i++){
            total = Math.max(nums[i] + first, second);
            first = second;
            second = total;
        }
        return total;
    }

    //constraints make sure accumulation won't overflow
    //base pattern:
    //accumulate most within array's length
    //every time we can choose pick this one, or start from next index
//     public int rob(int[] nums) {
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, -1);
//         return robTotal(nums, dp, 0);
//     }

//     private int robTotal(int[] nums, int[] dp, int index){
//         if(index >= nums.length) return 0;
//         else if(dp[index] >= 0){
//             return dp[index];
//         }else{
//             dp[index] = Math.max(nums[index] + robTotal(nums, dp, index + 2), robTotal(nums, dp, index + 1));
//             return dp[index];
//         }
//     }
}
