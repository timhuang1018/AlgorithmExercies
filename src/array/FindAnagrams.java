package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = getCharCount(p);
        int left =0,right=0,missing = map.size();
        List<Integer> result = new ArrayList<>();

        while (right<s.length()){

            if (right - left == p.length()){
                char c = s.charAt(left);
                if (map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if (map.get(c)==1) missing++;
                }
                left++;
            }
            char n = s.charAt(right);
            if (map.containsKey(n)){
                map.put(n,map.get(n)-1);
                if (map.get(n)==0) missing--;
            }
            right++;
            if (missing==0) result.add(left);
        }
        return result;
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

}
