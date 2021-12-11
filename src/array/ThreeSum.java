package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    //similar to two pointer , traverse and at each index , use two pointer
    //but index and two pointer , three of them may have duplicate
    //hence every update of index should consider duplicate
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int start= i+1, end = nums.length -1;
            if (i>0 && nums[i]==nums[i-1]) continue;
            while (start<end){
                if(nums[start] + nums[i] + nums[end] == 0){
                    result.add(Arrays.asList(nums[start], nums[i], nums[end]));
                    start++; end--;
                    while( start<end && nums[start]== nums[start-1]) start++;
                    while( start<end && nums[end] == nums[end + 1]) end--;
                }else if(nums[start] + nums[i] + nums[end]<0){
                    start++;
                } else{
                    end--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //-4,-1,-1,0,1,2
        //[-1,2]
        //expected [[-1, 2, -1], [-1, 1, 0]]
//        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));;
        //[-2,0,1,1,2]
        //expected [[-2,0,2],[-2,1,1]]
        System.out.println(threeSum(new int[]{-2,0,1,1,2}));
        System.out.println(threeSum(new int[]{0,0,0,0}));
        System.out.println(threeSum(new int[]{0,0,0}));
        System.out.println(threeSum(new int[]{0,1,1}));
        System.out.println(threeSum(new int[]{-1,-1,-1,1}));
        //expected [-1,0,1]
        System.out.println(threeSum(new int[]{1,-1,-1,0}));
    }
}
