package com.scaler.Scaler.Tries;

//Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N, which has maximum XOR value.
//
//        NOTE: If there are multiple subarrays with the same maximum value, return the subarray with minimum length. If the length is the same, return the subarray with the minimum starting index.
public class MaximumXORSubArray {

    public static void main(String[] args) {
        MaximumXORSubArray maximumXORSubArray = new MaximumXORSubArray();
        maximumXORSubArray.solve(new int[]{1, 2, 3, 4, 5});

    }

    //    maximum subarray xor => maximum xor pair from prefix xor array
    void bruteforce(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] pfxor = new int[A.length];
        pfxor[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pfxor[i] = pfxor[i - 1] ^ A[i];
        }
        int maxSubarrayXor = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int subarrayXor = pfxor[j] ^ (i > 0 ? pfxor[i - 1] : 0);
                maxSubarrayXor = Math.max(maxSubarrayXor, subarrayXor);
            }
        }
        System.out.println("The maximum XOR subarray value is " + maxSubarrayXor);
    }

    public void solve(int[] A) {
        //    maximum subarray xor => maximum xor pair from prefix xor array
        // but there need a
        int n = A.length;
        int[] pfxor = new int[n];
        pfxor[0] = A[0];
        for (int i = 1; i < n; i++) {
            pfxor[i] = pfxor[i - 1] ^ A[i];
        }

        Trie trie = new Trie();
        trie.insert(0);
        int maxXor = Integer.MIN_VALUE;

        for (int j = 0; j < n; j++) {
            int current = pfxor[j];
            int currentMax = trie.query(current);
            if (currentMax > maxXor) {
                maxXor = currentMax;
            }
            trie.insert(current);
        }
        System.out.println("The maximum XOR subarray value is " + maxXor);
    }

    class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[2];
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(int num) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }

        public int query(int num) {
            TrieNode node = root;
            int res = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int desired = 1 - bit;
                if (node.children[desired] != null) {
                    res |= (1 << i);
                    node = node.children[desired];
                } else {
                    node = node.children[bit];
                }
            }
            return res;
        }
    }
}
