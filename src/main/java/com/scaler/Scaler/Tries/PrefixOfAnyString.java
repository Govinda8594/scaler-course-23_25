package com.scaler.Scaler.Tries;

import java.util.HashMap;
import java.util.Map;

public class PrefixOfAnyString {

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] inputStrings = {"apple", "banana", "cherry", "date", "elderberry"};
        for (String s : inputStrings) {
            trie.insert(s);
        }
        String[] queries = {"a", "app", "ban", "berry", "c", "d", "e", "f"};
        for (String q : queries) {
            System.out.println("Is " + q + " a prefix of any input string? " + trie.startsWith(q));
        }
        /////////////////brute force //////////////////
        String[] inputStrings1 = {"apple", "banana", "cherry", "date", "elderberry"};
        String[] queries1 = {"a", "app", "ban", "berry", "c", "d", "e", "f"};
        for (String q : queries1) {
            boolean isPrefix = isPrefixOfAnyInputString1(inputStrings1, q);
            System.out.println(isPrefix ? "YES" : "NO");
        }
    }

    public static boolean isPrefixOfAnyInputString1(String[] inputStrings, String query) {
        for (String s : inputStrings) {
            if (s.startsWith(query)) {
                return true;
            }
        }
        return false;
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return true;
    }
}
