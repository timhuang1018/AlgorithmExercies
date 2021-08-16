package stack;

import java.util.Stack;

/**
 * Return the lexicographically smallest subsequence of s
 * that contains all the distinct characters of s exactly once.
 *
 * Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/
 */
public class SmallestSubsequence {

    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()){
            count[c-'a']++;
        }

        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            count[c-'a']--;

            //skip if char already in the stack
            if (visited[c-'a']){
                continue;
            }

            //have smaller value of char, and the bigger one have duplicate later
            while (!stack.isEmpty() && c< stack.peek() && count[stack.peek()-'a']>0){
                visited[stack.pop()-'a'] = false;
            }

            stack.push(c);

            visited[c-'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
