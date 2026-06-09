package com.scaler.Scaler.Tries;

import java.util.HashMap;

//Given two arrays of strings A of size N and B of size M.
//        Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using exactly one modification in B[i], Else C[i] = '0'.
//        NOTE: modification is defined as converting a character into another character.
public class ModifiedSearch {

    public String solve(String[] A, String[] B) {
        StringBuilder ans = new StringBuilder();
        Node root = new Node();
        for (String word : A) {
            put(word, root);
        }
        for (String word : B) {
            ans.append(search(word, root, 0, 0) ? 1 : 0);
        }
        return ans.toString();
    }

    private void put(String word, Node root) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            current.child.putIfAbsent(ch, new Node());
            current = current.child.get(ch);
        }
        current.isEnd = true;
    }

    private boolean search(String word, Node root, int index, int count) {
        if (count > 1 || index == word.length() && count != 1) {
            return false;
        }
        if (index == word.length() && root.isEnd) {
            return true;
        }
        boolean flag = false;
        char ch = word.charAt(index);
        for (char node : root.child.keySet()) {
            if (node == ch) {
                flag = flag | search(word, root.child.get(node), index + 1, count);
            } else {
                flag = flag | search(word, root.child.get(node), index + 1, count + 1);
            }
        }
        return flag;
    }

    class Node {
        boolean isEnd;
        HashMap<Character, Node> child;

        Node() {
            isEnd = false;
            child = new HashMap<>();
        }
    }
}
