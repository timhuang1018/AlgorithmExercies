package tree;

import java.util.*;

/**
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

    //time O(n2), space O(n) where n is the length of String s
    public boolean wordBreak(String s, List<String> wordDict){

        Queue<Integer> queue = new LinkedList<>();

        Set<Integer> set = new HashSet<>();

        //run once to have first index
        for(String word : wordDict){
            if(s.indexOf(word) == 0){
                if(s.length() == word.length()){
                    return true;
                }
                queue.offer(word.length());
                set.add(word.length());
            }
        }
        //before queue is not empty, see if we can match s length
        while(!queue.isEmpty()){
            int start = queue.poll();
            for(String word : wordDict){
                if(s.indexOf(word, start) == start){
                    int newStart = start + word.length();
                    if(newStart == s.length()){
                        return true;
                    }
                    if(set.contains(newStart)){
                        continue;
                    }
                    if(newStart < s.length()){
                        queue.offer(newStart);
                        set.add(newStart);
                    }
                }
            }
        }
        return false;
    }

}
