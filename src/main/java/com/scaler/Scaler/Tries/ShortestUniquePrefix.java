package com.scaler.Scaler.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a list of N words, find the shortest unique prefix to represent each word in the list.
//        NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible
public class ShortestUniquePrefix {
    public static void main(String[] args) {
        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix();
        shortestUniquePrefix.prefix(new String[]{"zebra", "dog", "duck", "dove"});
    }

    public String[] prefix(String[] arr) {
        List<String> ans = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (String s : arr) {
            makeTrie(s, root);
        }

        for (String s : arr) {
            ans.add(makePrefix(s, root));
        }
        return ans.toArray(new String[0]);
    }

    void makeTrie(String s, TrieNode root) {
        TrieNode cur = root;
        for (char ch : s.toCharArray()) {
            cur.map.putIfAbsent(ch, new TrieNode());
            cur.freq++;
            cur = cur.map.get(ch);
        }
    }

    String makePrefix(String s, TrieNode root) {
        TrieNode cur = root;
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (cur.freq == 1)
                break;
            ans.append(ch);
            cur = cur.map.get(ch);
        }
        return ans.toString();
    }

    static class TrieNode {
        int freq;
        Map<Character, TrieNode> map;

        TrieNode() {
            freq = 0;
            map = new HashMap<>();
        }
    }
}


