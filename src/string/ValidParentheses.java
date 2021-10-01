package string;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if(s.length() %2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '}'){
                if(!stack.isEmpty() && stack.pop() == '{'){
                    continue;
                }
                return false;
            }else if (c == ']'){
                if(!stack.isEmpty() && stack.pop() == '['){
                    continue;
                }
                return false;
            }else if (c == ')' ){
                if(!stack.isEmpty() && stack.pop() == '('){
                    continue;
                }
                return false;
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}
