package com.scaler.Scaler.Tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//There is a dictionary A of N words, and ith word has a unique weight Wi.
//        Another string array B of size M contains the prefixes. For every prefix B[i], output atmost 5 words from the dictionary A that start with the same prefix.
//        Output the words in decreasing order of their weight.
//        NOTE: If there is no word that starts with the given prefix output -1.
public class Autocomplete {
    static void put(String word, Node root, int idx) {
        Node current = root;
        for (char c : word.toCharArray()) {
            current.hm.putIfAbsent(c, new Node());
            current = current.hm.get(c);
            if (current.idx.size() < 5) {
                current.idx.add(idx);
            }
        }
        current.isEnd = true;
    }

    static void searching(String prefix, Node root, Pair[] words) {
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.hm.containsKey(ch)) {
                System.out.println("-1 ");
                return;
            }
            current = current.hm.get(ch);
        }
        for (int index : current.idx) {
            System.out.print(words[index].word + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] words = new String[n], prefixes = new String[m];
            int[] weights = new int[n];
            for (int j = 0; j < n; j++) {
                words[j] = sc.next();
            }
            for (int j = 0; j < n; j++) {
                weights[j] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                prefixes[j] = sc.next();
            }
            Pair[] pair = new Pair[n];
            for (int j = 0; j < n; j++) {
                pair[j] = new Pair(words[j], weights[j]);
            }
            Arrays.sort(pair, (a, b) -> b.weight - a.weight);
            Node root = new Node();
            for (int j = 0; j < pair.length; j++) {
                put(pair[j].word, root, j);
            }
            for (String prefix : prefixes) {
                searching(prefix, root, pair);
            }
        }
    }

    public static class Node {
        HashMap<Character, Node> hm;
        // store idx of word that matched with prefix[i] at each trie node, so that later we return the word that match the prefix
        ArrayList<Integer> idx;
        boolean isEnd;

        Node() {
            hm = new HashMap<>();
            idx = new ArrayList<>();
            isEnd = false;
        }
    }

    public static class Pair {
        String word;
        int weight;

        Pair(String s, int w) {
            word = s;
            weight = w;
        }
    }
}
