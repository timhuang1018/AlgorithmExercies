package stack;

import java.util.Stack;

/**
 * Given a string s which represents an expression,
 * evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * Note: You are not allowed to use any built-in function,
 * which evaluates strings as mathematical expressions, such as eval().
 *
 * Input: s = "3+2*2"
 * Output: 7
 * Input: s = " 3/2 "
 * Output: 1
 * Input: s = " 3+5 / 2 "
 * Output: 5
 */
public class BasicCaculator {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';

        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                currentNumber = currentNumber * 10 + (c-'0');
            }

            if (i== s.length()-1 ||(c!=' ' && !Character.isDigit(c))){
                if (operation=='*'){
                    stack.push(stack.pop() * currentNumber );
                }else if (operation=='/'){
                    stack.push(stack.pop() / currentNumber );
                }else if (operation=='+'){
                    stack.push(currentNumber);
                }else if (operation=='-'){
                    stack.push(-currentNumber);
                }

                currentNumber = 0;
                operation = c;
            }
        }

        int result = 0;
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        //expected 7
        System.out.println(calculate("3+2*2"));

        //expected 1
        System.out.println(calculate(" 3/2 "));

        //expected 42
        System.out.println(calculate("42"));

        System.out.println('2'-'0');
    }
}
