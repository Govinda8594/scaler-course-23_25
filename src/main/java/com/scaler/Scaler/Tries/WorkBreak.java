package com.scaler.Scaler.Tries;

import java.util.HashMap;

public class WorkBreak {

    static class TrieNode {
        boolean isWord;
        HashMap<Character, TrieNode> ct;
        TrieNode() {
            this.isWord = false;
            this.ct = new HashMap<Character, TrieNode>();
        }
    }

    public int wordBreak(String A, String[] B) {
        TrieNode root = new TrieNode();
        for (String word : B) {
            insert(root, word);
        }
        if (segmentPossible(root, root, A, 0)) {
            return 1;
        }
        return 0;
    }

    public static boolean segmentPossible(TrieNode root, TrieNode node, String A, int idx) {
        if (idx == A.length() && node.isWord) {
            return true;
        }
        TrieNode t = root;
        for (int i = idx; i < A.length(); i++) {
            char ch = A.charAt(i);
            t = search(t, ch);
            if (t == null) {
                return false;
            }
            if (t.isWord) {
                if (segmentPossible(root, t, A, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void insert(TrieNode root, String word) {
        TrieNode t = root;
        char ch;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (!t.ct.containsKey(ch)) {
                t.ct.put(ch, new TrieNode());
            }
            t = t.ct.get(ch);
        }
        t.isWord = true;
    }

    public static TrieNode search(TrieNode node, char ch) {
        if (node.ct.containsKey(ch)) {
            return node.ct.get(ch);
        }
        return null;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////

}
