package com.scaler.Scaler.Tries;

class MinimumXorPair {
    static int find_min(TrieNode root, int num) {
        TrieNode temp = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (temp.children[bit] != null) {
                // u find the bit u simply move to bit
                temp = temp.children[bit];
            } else {
                // if u don't find the bit u add the ans, because to have minimum xor,
                // and u move to previous bit,meaning u  had 1^1 or 0^0
                ans += (1 << i);
                temp = temp.children[1 - bit];
            }
        }
        return ans;
    }

    static void insert(TrieNode node, int num) {
        TrieNode temp = node;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (temp.children[bit] == null) {
                temp.children[bit] = new TrieNode();
            }
            temp = temp.children[bit];
        }
    }

    static int minxorpair(int N, int[] arr) {
        int ans = Integer.MAX_VALUE;
        TrieNode root = new TrieNode();
        insert(root, arr[0]);
        for (int i = 1; i < N; i++) {
            ans = Math.min(ans, find_min(root, arr[i]));
            insert(root, arr[i]);
        }
        return ans;
    }

    static class TrieNode {
        TrieNode[] children; // Instead of separate 'one' and 'zero' pointers

        TrieNode() {
            children = new TrieNode[2]; // Initialize an array for 0 and 1
        }
    }
}