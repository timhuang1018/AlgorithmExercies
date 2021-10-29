package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 */
public class WordDictionary {

    TrieNode root = new TrieNode();

    public WordDictionary() {
    }

    public void addWord(String word) {
        TrieNode current = root;
        for(Character c : word.toCharArray()){
            if(current.children.get(c) == null){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }

        current.endOfWord = true;
    }

    //use recursion since case '.' will need to walk through all chars
    public boolean search(String word) {
        return matchDfs(word, 0, root);
    }

    public boolean matchDfs(String word, int index,TrieNode current){

        if(index == word.length()){
            return current.endOfWord;
        }

        char c = word.charAt(index);

        if(c == '.' && !current.children.isEmpty()){
            for(TrieNode node : current.children.values()){
                if(matchDfs(word, index + 1, node)){
                    return true;
                }
            }
        }

        if(current.children.get(c) == null){
            return false;
        }

        return matchDfs(word, index + 1, current.children.get(c));
    }

    static class TrieNode{
        boolean endOfWord;
        Map<Character, TrieNode> children = new HashMap<>();
    }
}
