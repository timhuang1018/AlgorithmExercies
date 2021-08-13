package stack;

import java.util.Stack;

/**
 *
 * Given two integer arrays pushed and popped each with distinct values,
 * return true if this could have been the result of a sequence of push and pop operations
 * on an initially empty stack, or false otherwise.
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4),
 * pop() -> 4,
 * push(5),
 * pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 */
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length<=1) return true;
        Stack<Integer> stack = new Stack<>();
        int i=0, k=0;
        while (i<popped.length){
            if (k==pushed.length && popped[i]!=stack.peek()){
                return false;
            }

            if (stack.isEmpty() || popped[i]!=stack.peek()){
                stack.push(pushed[k]);
                k++;
            }else if (popped[i]==stack.peek()){
                stack.pop();
                i++;
            }
        }
        return true;
    }
}
