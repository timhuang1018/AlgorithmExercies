package stack;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string],
 * where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid;
 * No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits
 * and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 */
public class DecodeString {

    public static String decodeString(String s) {
        String result = "";
        Stack<Integer> timesContainer = new Stack<>();
        Stack<String> tempResult = new Stack<>();

        int i = 0;
        while (i< s.length()){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                int count = 0;
                while (Character.isDigit(c)){
                    count = 10 * count + ( c - '0');
                    c = s.charAt(++i);
                }
                timesContainer.push(count);

            } else if (c=='['){
                tempResult.push(result);
                result = "";
                i++;
            }else if (c==']'){

                StringBuilder tempSb = new StringBuilder(tempResult.pop());
                int times = timesContainer.pop();
                while (times>0){
                    tempSb.append(result);
                    times--;
                }
                result = tempSb.toString();
                i++;

            }else {
                result += c;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String t1 = decodeString("2[abc]3[cd]ef");
        //expected "abcabccdcdcdef"
        System.out.println(t1);
        String t2 = decodeString("3[a]2[bc]");
        //expected "aaabcbc"
        System.out.println(t2);

        //expected abccdcdcdxyz
        String t4 = decodeString("abc3[cd]xyz");
        System.out.println(t4);
    }
}
