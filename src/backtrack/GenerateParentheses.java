package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 */
public class GenerateParentheses {


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, result, new StringBuilder(), 0, 0);
        return result;
    }

    public void dfs(int n, List<String> result, StringBuilder sb, int count,int pars){

        if(sb.length() > n * 2){
            return;
        }

        if(n == pars && count == 0){
            result.add(sb.toString());
            return;
        }

        sb.append('(');
        count++;
        dfs(n, result, sb, count, pars);
        count--;
        sb.deleteCharAt(sb.length()-1);

        sb.append(')');
        if (count >0 ){
            //means there have at least one '('
            //increment correct pars
            pars++;
        }
        count--;
        dfs(n, result, sb, count, pars);
        sb.deleteCharAt(sb.length()-1);
    }

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        System.out.println(solution.generateParenthesis(3));
    }
}
