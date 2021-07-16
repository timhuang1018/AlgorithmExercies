package array;

import java.util.HashMap;

/**
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> map = getCharCount(t);
        int left = 0, right = 0, missing = map.size(), tempL=0, tempR = Integer.MAX_VALUE;
        while (right < s.length()){
            if (missing>0){
                char n =s.charAt(right);
                if (map.containsKey(n)){
                    map.put(n,map.get(n)-1);
                    if (map.get(n)==0) missing--;
                }
            }else {
                char c = s.charAt(left);
                if (map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if(map.get(c)==1) missing++;
                }
                left++;
            }

            if (missing==0){
                if (right - left < tempR - tempL){
                    tempL = left;
                    tempR = right;
                }
            } else{
                right++;
            }
        }
        if (tempR<Integer.MAX_VALUE){
            return s.substring(tempL,tempR) + s.charAt(tempR);
        }
        return "";
    }

    public static HashMap<Character, Integer> getCharCount(String text){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0;i<text.length();i++){
            char c = text.charAt(i);
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        //expected "BANC"
        String t1 = minWindow(
                //    l       r
                "ADOBECODEBANC",
                "ABC"
        );
        System.out.println("answer:"+t1);


        String t2 = minWindow(
                //        l     r
                "a",
                "b"
        );
        System.out.println("answer:"+t2);

    }
}
