package array;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring T
 * that contains at most k distinct characters.
 */
public class LongestSubstringWithDistinctChars {

    public static int longestSubstringWithDistinctChars(String input, int k){

        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;
        while (right < input.length()){
            if (map.size()<=k){
                char c = input.charAt(right);
                map.put(c,right);
                right++;
            }else {
                char c = input.charAt(left);
                if (map.containsKey(c) && map.get(c)==left){
                    map.remove(c);
                }
                left++;
            }
            if (map.size()==k){
                maxLength = Math.max(right-left, maxLength);
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int t1 = longestSubstringWithDistinctChars("eceba", 2);
        assert t1 == 3;
        int t2 = longestSubstringWithDistinctChars("aa", 1);
        assert t2 == 2;
    }
}
