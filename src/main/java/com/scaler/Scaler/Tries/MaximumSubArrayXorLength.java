package com.scaler.Scaler.Tries;

public class MaximumSubArrayXorLength {

    public int[] solve(int[] A) {
        int n = A.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] ^ A[i - 1];
        }

        Trie trie = new Trie();
        trie.insert(prefix[0], 0);

        int maxXor = 0;
        int minLength = Integer.MAX_VALUE;
        int start = Integer.MAX_VALUE;
        int end = -1;

        for (int i = 1; i <= n; i++) {
            int j = trie.query(prefix[i]);
            int currentXor = prefix[i] ^ prefix[j];
            int length = i - j;

            if (currentXor > maxXor) {
                maxXor = currentXor;
                minLength = length;
                start = j;
                end = i;
            } else if (currentXor == maxXor) {
                if (length < minLength) {
                    minLength = length;
                    start = j;
                    end = i;
                } else if (length == minLength && j < start) {
                    start = j;
                    end = i;
                }
            }

            trie.insert(prefix[i], i);
        }

        return new int[]{start + 1, end};
    }

    class TrieNode {
        TrieNode[] children;
        int index;

        public TrieNode() {
            children = new TrieNode[2];
            index = -1;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(int num, int idx) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
            node.index = idx;
        }

        public int query(int num) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int desired = 1 - bit;
                if (node.children[desired] != null) {
                    node = node.children[desired];
                } else {
                    node = node.children[bit];
                }
            }
            return node.index;
        }
    }
}
