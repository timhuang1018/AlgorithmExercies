package data;


import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public boolean endOfWord;
    public Map<Character, TrieNode> children = new HashMap<>();
//    public TrieNode(int size){
//        children = new TrieNode[size];
//    }
}
