package array;

import java.util.HashMap;

/**
 * Given a string s which consists of lowercase or uppercase letters,
 * return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example,
 * "Aa" is not considered a palindrome here.
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int result = 0;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.remove(c);
                result += 2;
            }else {
                map.put(c,1);
            }
        }
        if (map.size()>0) result++;
        return result;
    }
}
