package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class LetterCombinationsOfPhoneNumber {

    List<String> stringList = Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        dfs(result, digits, 0, new StringBuilder());
        return result;
    }

    public void dfs(List<String> result, String digits, int index, StringBuilder temp){
        if(digits.length() == 0 || index > digits.length()){
            return;
        }

        if(index == digits.length()){
            result.add(temp.toString());
            return;
        }

        int listIndex = digits.charAt(index) - '0';
        //phone number start from 2
        String letters = stringList.get(listIndex - 2);

        for(int i = 0; i<letters.length(); i++){
            temp.append(letters.charAt(i));
            dfs(result, digits, index + 1, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
