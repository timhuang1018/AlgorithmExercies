package graph;

import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 *
 * For example,
 * Given the following words in dictionary,
 *
 * [
 * "wrt",
 * "wrf",
 * "er",
 * "ett",
 * "rftt"
 * ]
 * The correct order is: "wertf".
 *
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictionary {

    public String getLettersOrder(String[] words){
        if (words == null || words.length ==0 ) return "";
        if (words.length == 1) return words[0];

        int[] inDegree = new int[26];
        Map<Character, Set<Character>> graph = buildGraph(words, inDegree);

        StringBuilder result = new StringBuilder();
        System.out.println(graph);
        for (char node : graph.keySet()){
            dfs(node, result, graph, inDegree);
        }
        return result.toString();
    }

    private void dfs(char node, StringBuilder result, Map<Character, Set<Character>> graph, int[] inDegree) {
        if (inDegree[node - 'a'] > 0 || inDegree[node - 'a'] < 0){
            return;
        }
        result.append(node);
        //make node as visited
        inDegree[node - 'a']--;

        for (char child : graph.get(node)){
            //decrement child indegree to find next candidate
            inDegree[child - 'a']--;
            dfs(child, result, graph, inDegree);
        }
    }

    private Map<Character, Set<Character>> buildGraph(String[] words, int[] inDegree) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        //prepare adjacency list for each char
        for (String word :words){
            for (char c : word.toCharArray()){
                graph.put(c, new HashSet<>());
            }
        }

        for (int i = 1; i< words.length; i++){
            String firstWord = words[i - 1];
            String secondWord = words[i];
            int minLength = Math.min(firstWord.length(), secondWord.length());

            for (int j =0; j< minLength; j++){
                char parent = firstWord.charAt(j);
                char child = secondWord.charAt(j);
                if (parent != child){
                    if (!graph.get(parent).contains(child)){
                        graph.get(parent).add(child);
                        inDegree[child - 'a']++;
                    }
                    break;
                }
            }
        }

        return graph;
    }

    public static void main(String[] args) {
        AlienDictionary solution = new AlienDictionary();

        //expected "wertf"
        String t1 = solution.getLettersOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        System.out.println(t1);
        //expected "zx"
        String t2 = solution.getLettersOrder(new String[]{"zx"});
        System.out.println(t2);
        //expected ""
        String t3 = solution.getLettersOrder(new String[]{"z", "x", "z"});
        System.out.println(t3);
    }
}
