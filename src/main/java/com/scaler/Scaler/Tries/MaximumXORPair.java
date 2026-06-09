package com.scaler.Scaler.Tries;

//Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.
public class MaximumXORPair {
    public int solve(int[] A) {
        Node root = new Node();
        int max = Integer.MIN_VALUE;
        for (int j : A) {
            max = Math.max(max, j);
        }
        int p = -1;
        for (int i = 31; i >= 0; i--) {
            if ((max >> i & 1) == 1) {
                p = i;
                break;
            }
        }
        for (int j : A) {
            insert(root, j, p);
        }
        int ans = Integer.MIN_VALUE;
        for (int j : A) {
            ans = Math.max(ans, maxXor(root, j, p));
        }
        return ans;
    }

    void insert(Node root, int num, int p) {
        Node current = root;
        for (int i = p; i >= 0; i--) {
            int bit = (num >> i & 1);
            if (current.child[bit] == null) {
                current.child[bit] = new Node();
            }
            current = current.child[bit];
        }
    }

    int maxXor(Node root, int num, int p) {
        int ans = 0;
        Node current = root;
        for (int i = p; i >= 0; i--) {
            int bit = (num >> i & 1);
            if (current.child[1 - bit] != null) { // finding the 0 or 1 in prefix tree for 0^1 or 1^0
                ans = ans | (1 << i);
                current = current.child[1 - bit];
            } else {
                current = current.child[bit];
            }
        }
        return ans;
    }

    class Node {
        Node[] child;

        Node() {
            child = new Node[2];
        }
    }
}
