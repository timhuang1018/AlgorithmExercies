package trie;


import java.util.HashMap;
import java.util.Map;

/**
 * A trie (pronounced as “try”) or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
 * There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * int countWordsEqualTo(String word) Returns the number of instances of the string word in the trie.
 * int countWordsStartingWith(String prefix) Returns the number of strings in the trie that have the string prefix as a prefix.
 * void erase(String word) Erases the string word from the trie.
 */
public class ImplementTrieII {

    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode current = root;
        for(Character c : word.toCharArray()){
            if(current.children.get(c) == null){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
            current.prefixCount++;
        }
        //same word may insert more than once
        current.wordCount++;
    }

    public int countWordsEqualTo(String word){
        TrieNode current = root;
        for(Character c : word.toCharArray()){
            if(current.children.get(c) == null){
                return 0;
            }
            current = current.children.get(c);
        }
        return current.wordCount;
    }

    public int countWordsStartingWith(String prefix){
        TrieNode current = root;
        for(Character c : prefix.toCharArray()){
            if(current.children.get(c) == null){
                return 0;
            }
            current = current.children.get(c);
        }
        return current.prefixCount;
    }

    public void erase(String word){
        TrieNode current = root;

        for(Character c : word.toCharArray()){
            if(current.children.get(c) == null){
                return;
            }
            current = current.children.get(c);
            //going to erase word, above TrieNode should all minus one
            //TODO should minus amount consider wordCount ?
            current.prefixCount--;
        }
        current.wordCount = 0;
    }

    static class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public int prefixCount = 0;
        public int wordCount = 0;
    }

    public static void main(String[] args) {
        ImplementTrieII solution = new ImplementTrieII();
        solution.insert("apple");               // Inserts "apple".
        solution.insert("apple");               // Inserts another "apple".
        System.out.println(solution.countWordsEqualTo("apple"));;    // There are two instances of "apple" so return 2.
        System.out.println(solution.countWordsStartingWith("app"));; // "app" is a prefix of "apple" so return 2.
        solution.erase("apple");                // Erases one "apple".
        System.out.println(solution.countWordsEqualTo("apple"));;    // Now there is only one instance of "apple" so return 1.
        System.out.println(solution.countWordsStartingWith("app"));; // return 1
        solution.erase("apple");                // Erases "apple". Now the trie is empty.
        System.out.println(solution.countWordsStartingWith("app"));; // return 0
    }
}
