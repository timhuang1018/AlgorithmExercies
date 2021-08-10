package stack;

import java.util.Stack;

/**
 * You are given a string s consisting of lowercase English letters.
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 * It can be proven that the answer is unique.
 *
 * Input: s = "abbaca"
 * Output: "ca"
 *
 * Input: s = "azxxzy"
 * Output: "ay"
 */
public class RemoveAllAdjacentDuplicates {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek()==c){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            result =  stack.pop() + result;
        }
        return result;
    }
}
