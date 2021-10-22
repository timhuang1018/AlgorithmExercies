package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target,  0, result, new ArrayList<>());
        return result;
    }

    public void dfs(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> temp){

        if(target < 0){
            return;
        }

        if(target == 0){
            List<Integer> copy = new ArrayList<>(temp);
            result.add(copy);
            return;
        }

        for(int i = index; i<candidates.length; i++){
            temp.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, result, temp); //element could be reused , no need to increment index
            temp.remove(temp.size() - 1);
        }
    }
}
