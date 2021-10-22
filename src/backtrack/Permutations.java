package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Permutations {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, new ArrayList<>());
        return result;
    }

    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> temp){

        if(temp.size() == nums.length ){
            List<Integer> copy = new ArrayList<>(temp);
            result.add(copy);
            return;
        }

        for(int i = 0; i<nums.length; i++){
            //not using same element
            if (temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, result, temp);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        Permutations solution = new Permutations();
        System.out.println(solution.permute(new int[]{1,2,3}));
    }
}
