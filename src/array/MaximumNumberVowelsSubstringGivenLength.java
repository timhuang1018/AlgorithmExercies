package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */
public class MaximumNumberVowelsSubstringGivenLength {

    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int max = 0, left = 0, temp=0;

        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            //join Character
            if(set.contains(c)){
                temp++;
            }

            //validate max count when length k
            if(right - left + 1 == k){
                max = Math.max(max, temp);

                //leave Character
                if(set.contains(s.charAt(left))){
                    temp--;
                }
                left++;
            }

        }

        return max;
    }
}
