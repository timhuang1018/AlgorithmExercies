package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 *
 * Note:
 *
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.

 * Examples:
 * input: 32
 * output:

 */
public class FactorCombination {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, result, new ArrayList<>(), 1, 2);
        return result;
    }

    public void dfs(int n, List<List<Integer>> result, List<Integer> temp, int factor, int index){
        //1 is edge case
        if (n== 1 || factor > n){
            return;
        }

        if (factor == n){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i<n; i++){
            if (n % i == 0){
                temp.add(i);
                dfs(n, result, temp, factor * i, i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        FactorCombination solution = new FactorCombination();
        //expected []
        System.out.println(solution.getFactors(1));

        //expected []
        System.out.println(solution.getFactors(37));

        /* [
             [2, 6],
             [2, 2, 3],
             [3, 4]
           ]    */
        System.out.println(solution.getFactors(12));

        /* [
            [2, 16],
            [2, 2, 8],
            [2, 2, 2, 4],
            [2, 2, 2, 2, 2],
            [2, 4, 4],
            [4, 8]
           ]  */
        System.out.println(solution.getFactors(32));
    }
}
