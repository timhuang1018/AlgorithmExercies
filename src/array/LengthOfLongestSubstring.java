package array;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String input) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;
        while (right < input.length()){
            char c = input.charAt(right);
            if (map.containsKey(c)){
                map.remove(input.charAt(left));
                left++;
                continue;
            }
            map.put(c,right);
            maxLength = Math.max(right-left+1, maxLength);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
//        System.out.println(
//                lengthOfLongestSubstring("abcabcbb")
//        );
        System.out.println(
                lengthOfLongestSubstring("tmmzuxt")
        );
    }


}
