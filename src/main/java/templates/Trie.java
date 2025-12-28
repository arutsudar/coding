package templates;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    // Start node
    private static TrieNode start;

    private static class TrieNode {
        // Mapping for the next node(s) from current node
        TrieNode[] next = new TrieNode[26];

        // Contains all the words which has the prefix matching with the path from start node till current node
        List<String> ans = new ArrayList();
    }

    private static void insertWord(String word) {
        TrieNode curr = start;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            TrieNode[] next = curr.next;
            if (next[index] == null)
                next[index] = new TrieNode();
            next[index].ans.add(word); // Adding the word to the list
            curr = next[index];
        }
    }

    private static List<String> getWords(String prefix) {
        TrieNode curr = start;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (curr == null)
                return new ArrayList<>();
            TrieNode[] next = curr.next;
            if (next[index] == null)
                return new ArrayList<>();
            curr = next[index];
        }
        return curr.ans;
    }

}