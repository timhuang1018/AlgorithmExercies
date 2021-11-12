package array;

import java.util.HashMap;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class ValidAnagram {
    public boolean isAnagram(String first, String second){
        //anagram have to same length for both string
        if (first ==null || second==null || first.length()!=second.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i< first.length(); i++){
            char cFirst = first.charAt(i);
            updateMap(cFirst, 1, map);
            char cSecond = second.charAt(i);
            updateMap(cSecond, -1, map);
        }

        return map.isEmpty();
    }

    public void updateMap(char key, int defaultValue, HashMap<Character, Integer> map){
        if (map.containsKey(key)){
            map.put(key,map.get(key) + defaultValue);
        }else {
            map.put(key,defaultValue);
        }
        if (map.get(key) == 0){
            map.remove(key);
        }
    }
}
