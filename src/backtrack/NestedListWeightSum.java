package backtrack;

import data.NestedInteger;
import data.NestedIntegerImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Input:
 * [[1,1],2,[1,1]]
 * Output:
 * 10
 * Explanation:
 * Four 1's at depth 2, one 2 at depth 1.
 *
 * Input:
 * [1,[4,[6]]]
 * Output:
 * 27
 * Explanation:
 * One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 */
public class NestedListWeightSum {


    public int depthSum(List<NestedInteger> nestedList){
        int result = 0;
        for (int i = 0; i < nestedList.size(); i++){
            result += dfs(nestedList.get(i), 1);
        }
        return result;
    }

    private int dfs(NestedInteger nested, int depth){
        if(nested.isInteger()){
            return nested.getInteger() * depth;
        }

        int result = 0;
        for(int j = 0; j < nested.getList().size(); j++){
            result += dfs(nested.getList().get(j), depth + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        NestedListWeightSum solution = new NestedListWeightSum();

        //example 1 [[1,1],2,[1,1]]
        List<NestedInteger> nestedList = new ArrayList<>();
        List<NestedInteger> first = new ArrayList<>();
        List<NestedInteger> second = new ArrayList<>();
        first.add(new NestedIntegerImpl(1, null));
        first.add(new NestedIntegerImpl(1,null));
        second.add(new NestedIntegerImpl(1,null));
        second.add(new NestedIntegerImpl(1,null));
        nestedList.add(new NestedIntegerImpl(null, first));
        nestedList.add(new NestedIntegerImpl(2, null));
        nestedList.add(new NestedIntegerImpl(null, second));
        //expected 1
        System.out.println(solution.depthSum(nestedList));

        //example 2 [1,[4,[6]]]
        List<NestedInteger> nestedIntegerList = new ArrayList<>();
        List<NestedInteger> firstInner = new ArrayList<>();
        List<NestedInteger> secondInner = new ArrayList<>();
        secondInner.add(new NestedIntegerImpl(6,null));
        firstInner.add(new NestedIntegerImpl(4, null));
        firstInner.add(new NestedIntegerImpl(null,secondInner));
        nestedIntegerList.add(new NestedIntegerImpl(1,null));
        nestedIntegerList.add(new NestedIntegerImpl(null, firstInner));
        //expected 27
        System.out.println(solution.depthSum(nestedIntegerList));
    }
}
