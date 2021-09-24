package array;


import java.util.*;

/**
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 *
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 *
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * Notice that |val| denotes the absolute value of val.
 *
 * Example 1:
 *
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 *
 * Input: nums = [1,3,1,5,4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 *
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 */
public class FindKdiffPairInArray {

    //two pointers
    public static int findPair(int[] nums, int k){
        Arrays.sort(nums);
        int count = 0, start = 0, end = start+1;

        while (start < nums.length && end < nums.length){
            int diff = Math.abs(nums[end] - nums[start]);
            if(diff < k){
                end++;
            }else if(diff > k){
                start++;
            }else {
                count++;
                start++;
                end++;
                while (start < nums.length && nums[start] == nums[start - 1]){
                    start++;
                }
                while (end < nums.length && nums[end] == nums[end-1]){
                    end++;
                }
            }

            if (k==0){
                end = start+1;
            }
        }
        return count;
    }

    //use hash map to avoid used value
    // meet requirement of nums[i] = nums[j]+k, identify these as map key
    // separate into k is 0 and other case
    public int findPairs3(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            if (k==0 && map.getOrDefault(i,0)==1){
                count++;
            }
            map.put( i, map.getOrDefault(i,0) + 1);
        }

        if (k==0){
            return count;
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (map.containsKey(entry.getKey()+k)){
                count++;
            }
        }

        return count;
    }


    //original
    //sort array to utilize binary search for second value
    //use set to avoid used value
    public int findPairs2(int[] nums, int k) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            int value = nums[i], left = i + 1, right = nums.length - 1;

            while(left<=right){
                int mid = left + (right - left)/2;

                if(Math.abs(value - nums[mid]) == k){
                    if(set.contains(value + nums[mid])){
                        break;
                    }
                    set.add(value + nums[mid]);
                    count++;
                    break;
                }else if(Math.abs(value - nums[mid]) > k){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPair(new int[]{1,3,1,5,4} , 0));
    }
}
