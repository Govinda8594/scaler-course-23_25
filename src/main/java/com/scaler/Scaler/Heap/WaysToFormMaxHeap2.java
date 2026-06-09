package com.scaler.Scaler.Heap;

public class WaysToFormMaxHeap2 {
    /*Max heap is a special kind of complete binary tree in which, for every node, the value present in that node is greater than the value present in its children nodes.

Given an array A of size N consisting of N - 1 distinct elements. In other words, there is exactly one element that is repeated.
It is given that the element that would repeat would be either the maximum element or the minimum element.

Find the number of structurally different Max heaps possible using all the N elements of the array i.e., Max heap of size N.

As the final answer can be very large return your answer modulo 109 + 7.*/
    final int mod = 1000000007;  // Modulo constant
    final int max = 1005;        // Maximum size for precomputation
    long[] dp;                   // DP array for standard recurrence
    long[] dp2;                  // DP array for special recurrence (min freq = 2)
    long[][] nck;                // Precomputed binomial coefficients
    int[] leftSize;              // Precomputed left subtree sizes for complete CBTs

    public WaysToFormMaxHeap2() {
        dp = new long[max];
        dp2 = new long[max];
        nck = new long[max][max];
        leftSize = new int[max];
        precompute();  // Precompute all necessary values
    }

    // Precomputes binomial coefficients, left subtree sizes, and DP arrays
    private void precompute() {
        // Precompute binomial coefficients (nCk) using dynamic programming
        for (int i = 0; i < max; i++) {
            nck[i][0] = 1;  // Base case: nC0 = 1
            for (int j = 1; j <= i; j++) {
                nck[i][j] = (nck[i - 1][j - 1] + nck[i - 1][j]) % mod;
            }
        }

        // Precompute left subtree sizes for complete BSTs of size n
        leftSize[0] = 0;  // Size 0 has no left subtree
        for (int n = 1; n < max; n++) {
            if (n == 1) {
                leftSize[n] = 0;  // Single node tree has no left subtree
            } else {
                int h = (int) (Math.log(n) / Math.log(2));  // Height of the complete BST
                int numh = (1 << h);                       // Nodes in full levels: 2^h
                int last = n - (numh - 1);                 // Nodes in the last level
                // Determine left subtree size based on last level nodes
                if (last >= numh / 2) {
                    leftSize[n] = numh - 1;
                } else {
                    leftSize[n] = (numh - 1) - ((numh / 2) - last);
                }
            }
        }

        // Base cases for DP arrays
        // Base cases for standard CBT counts (dp)
        dp[0] = 1;  // One empty tree
        dp[1] = 1;  // One single-node tree
        dp[2] = 1;  // One possible CBT for two nodes
        dp[3] = 2;  // Two possible CBTs for three nodes

        // Base cases for special CBT counts (dp2)
        dp2[0] = 0;  // No trees for size 0
        dp2[1] = 0;  // No trees for size 1
        dp2[2] = 1;  // One possible CBT for two nodes with duplicate minimum element
        dp2[3] = 1;  // One possible CBT for three nodes with duplicate minimum element

        // Precompute dp array using standard recurrence
        for (int n = 4; n < max; n++) {
            int left = leftSize[n];        // Left subtree size
            int right = n - 1 - left;      // Right subtree size
            dp[n] = nck[n - 1][left];        // Choose elements for left subtree
            dp[n] = (dp[n] * dp[left]) % mod;   // Recurse on left subtree
            dp[n] = (dp[n] * dp[right]) % mod;  // Recurse on right subtree
        }

        // Precompute dp2 array using special recurrence (for min freq = 2)
        for (int n = 4; n < max; n++) {
            int left = leftSize[n];        // Left subtree size
            int right = n - 1 - left;      // Right subtree size
            long term1 = 0, term2 = 0, term3 = 0;

            // Term 1: Both duplicate minima in left subtree
            if (left >= 2 && n - 3 >= left - 2) {
                term1 = nck[n - 3][left - 2];  // Choose elements for left subtree
                term1 = (term1 * dp2[left]) % mod;  // Recurse on left with special case
                term1 = (term1 * dp[right]) % mod;   // Recurse on right normally
            }

            // Term 2: Both duplicate minima in right subtree
            if (right >= 2 && n - 3 >= right - 2) {
                term2 = nck[n - 3][right - 2];  // Choose elements for right subtree
                term2 = (term2 * dp[left]) % mod;    // Recurse on left normally
                term2 = (term2 * dp2[right]) % mod;  // Recurse on right with special case
            }

            // Term 3: Duplicate minima split between subtrees
            if (left >= 1 && n - 3 >= left - 1) {
                term3 = nck[n - 3][left - 1];  // Choose elements for left subtree
                term3 = (term3 * dp[left]) % mod;    // Recurse on left normally
                term3 = (term3 * dp[right]) % mod;   // Recurse on right normally
            }

            dp2[n] = (term1 + term2 + term3) % mod;  // Combine results
        }
    }

    // Solves the problem using precomputed DP arrays
    public int solve(int[] A) {
        int n = A.length;
        if (n == 0) return 0;  // Edge case: empty array

        // Find minimum value and its frequency
        int minVal = Integer.MAX_VALUE;
        int minFreq = 0;
        for (int num : A) {
            if (num < minVal) {
                minVal = num;
                minFreq = 1;
            } else if (num == minVal) {
                minFreq++;
            }
        }

        // Return result based on minimum element frequency
        long result = (minFreq == 2) ? dp2[n] : dp[n];
        return (int) (result % mod);
    }
}
