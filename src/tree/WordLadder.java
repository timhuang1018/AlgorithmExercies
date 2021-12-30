package tree;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        //traverse each index at beginWord, consider 26 alphabet for this char
        Set<String> words = new HashSet<>(wordList);
        System.out.println(words);
        if(!words.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while(!queue.isEmpty()){
            System.out.println("level:"+level);
            int size = queue.size();

            while (size>0){
                String current = queue.poll();
                char[] chars = current.toCharArray();
                for(int j=0; j<chars.length; j++){
                    char origin = chars[j];
                    System.out.println("keep:"+origin);
                    for (char c = 'a'; c <= 'z'; c++){
                        if (origin == c) continue;
                        chars[j] = c;
                        String findWord = String.valueOf(chars);
                        if (findWord.equals(endWord)){
                            return level + 1;
                        }
                        if (words.contains(findWord)){
                            System.out.println("find word:"+findWord);
                            queue.offer(findWord);
                            words.remove(findWord);
                        }
                    }
                    chars[j] = origin;
                }
                size--;
            }
            level++;
        }

        return 0;
    }


    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        int level = solution.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(level);


        int l2 = solution.ladderLength("ymain","oecij", Arrays.asList("ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"));
        System.out.println(l2);
    }
}
