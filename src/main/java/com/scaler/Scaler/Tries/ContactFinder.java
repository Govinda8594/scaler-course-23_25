package com.scaler.Scaler.Tries;

import java.util.ArrayList;
import java.util.HashMap;

//We want to make a custom contacts finder applications as part of our college project. The application must perform two types of operations:
//        Type 1: Add name B[i] ,denoted by 0 in vector A where B[i] is a string in vector B denoting a contact name. This must store B[i] as a new contact in the application.
//        Type 2: Find partial for B[i] ,denoted by 1 in vector A where B[i] is a string in vector B denoting a partial name to search the application for. It must count the number of contacts starting with B[i].
//        You have been given sequential add and find operations. You need to perform each operation in order.
//        And return as an array of integers, answers for each query of type 2(denoted by 1 in A) .
public class ContactFinder {
    public class TrieNode {
        boolean isEnd;
        int wordCnt;
        HashMap<Character, TrieNode> map;
        TrieNode() {
            isEnd = false;
            wordCnt = 0;
            map = new HashMap<>();
        }

    }

    public int[] solve2(int[] A, String[] B) {
        int len = A.length;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < len; i++) {
            if (A[i] == 0) {
                // add word B[i] on to trie
                add(root, B[i]);
            } else {
                ans.add(find(root, B[i]));
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public void add(TrieNode root, String str) {
        TrieNode current = root;
        for (char ch : str.toCharArray()) {
            current.map.putIfAbsent(ch, new TrieNode());
            current = current.map.get(ch);
            current.wordCnt++;
        }
        current.isEnd = true;
    }

    public int find(TrieNode root, String str) {
        TrieNode current = root;
        for (char ch : str.toCharArray()) {
            if (!current.map.containsKey(ch)) {
                return 0;
            }
            current = current.map.get(ch);
        }
        return current.wordCnt;
    }
}
