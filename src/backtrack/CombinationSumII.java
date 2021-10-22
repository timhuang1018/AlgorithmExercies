package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 */
public class CombinationSumII {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
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
            if (i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            dfs(candidates, target - candidates[i], i+1, result, temp);
            temp.remove(temp.size() - 1);
        }

    }
}
