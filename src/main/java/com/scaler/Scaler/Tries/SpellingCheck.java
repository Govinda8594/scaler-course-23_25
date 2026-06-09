package com.scaler.Scaler.Tries;

import java.util.HashMap;

//Given an array of words A (dictionary) and another array B (which contain some words).
//        You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.
//        Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
//        Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.
//        NOTE: Try to do this in O(n) time complexity.
public class SpellingCheck {
    public int[] solve(String[] A, String[] B) {
        int[] ans = new int[B.length];
        Node root = insert(A);
        for (int i = 0; i < B.length; i++) {
            if (search(root, B[i])) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }

    public Node insert(String[] A) {
        Node root = new Node();
        for (String word : A) {
            Node temp = root;
            for (char c : word.toCharArray()) {
                temp.hm.putIfAbsent(c, new Node());
                temp = temp.hm.get(c);
            }
            temp.isTerminal = true;
        }
        return root;
    }

    public boolean search(Node root, String B) {
        for (char c : B.toCharArray()) {
            if (!root.hm.containsKey(c)) {
                return false;
            }
            root = root.hm.get(c);
        }
        return root.isTerminal;
    }

    static class Node {
        HashMap<Character, Node> hm;
        boolean isTerminal;

        Node() {
            hm = new HashMap<>();
            isTerminal = false;
        }
    }
}
