package com.scaler.Scaler.Tries;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers A of size N.
//        A triplet (i, j, k), i < j <= k is called a power triplet if A[i] ^ A[i+1] ^....A[j-1] = A[j] ^.....^A[k].
//        Where, ^ denotes bitwise xor.
//        Return the count of all possible power triplets. Since the answer could be large return answer % 109 +7.
public class XORTriplet {
    // Root of the trie
    private TrieNode1 root1;

    // O(n)
    public int solve(int[] A) {
        int mod = 1000000007;
        int n = A.length;
        // Map to store prefix XOR values: key is the prefix value,
        // value is an array where [0] = count of occurrences, [1] = sum of indices (in prefix array)
        Map<Integer, long[]> map = new HashMap<>();
        // Initialize with prefix 0 at index 0: count=1, sum=0
        map.put(0, new long[]{1, 0});

        int prefix = 0;
        long result = 0;

        for (int i = 0; i < n; i++) {
            prefix ^= A[i];
            if (map.containsKey(prefix)) {
                long[] arr = map.get(prefix);
                long count = arr[0];
                long totalSum = arr[1];
                // For each previous occurrence of this prefix, the contribution to triplets is:
                // (current_index - previous_index - 1) per previous occurrence.
                // Summing over all previous occurrences: (count * i) - totalSum
                result = (result + count * i - totalSum) % mod;
                // Update the map: increment count and add current prefix index (i+1) to totalSum
                arr[0] = count + 1;
                arr[1] = totalSum + (i + 1);
            } else {
                // First occurrence of this prefix: count=1, sum of indices = (i+1)
                map.put(prefix, new long[]{1, i + 1});
            }
        }

        // Adjust for negative result
        if (result < 0) {
            result += mod;
        }
        return (int) result;
    }

    // O(n * 32)
    public int solve2(int[] A) {
        // Initialize the trie root
        root1 = new TrieNode1();
        int ans = 0;
        int preXor = 0;
        int mod = 1000000007;
        // Insert initial prefix XOR 0 at index -1 (adjusted to 0 in the trie)
        insert(0, -1);
        for (int i = 0; i < A.length; i++) {
            // Update the current prefix XOR with the current element
            preXor = preXor ^ A[i];
            // Search for the current prefix XOR in the trie to get count and sum of previous indices
            Pair1 curr = search(preXor, i);
            if (curr == null) {
                // If not found, insert the current prefix XOR
                insert(preXor, i);
            } else {
                // Calculate the contribution to the triplet count using the formula
                // (current index i * previous prefix xor count) - (sum of indices so far At which Prefix xor occured)
                int val = ((i * curr.count) - curr.sum + mod) % mod;
                ans = (ans + val) % mod;
            }
        }
        return ans;
    }

    // Inserts a number (prefix XOR) into the trie along with its index
    void insert(int num, int index) {
        TrieNode1 temp = root1;
        // Process each bit from the most significant bit (30th) to the least (0th)
        for (int i = 30; i >= 0; i--) {
            // Extract the i-th bit
            int bit = (num >> i) & 1;
            // Create a new node if the path doesn't exist
            if (temp.children[bit] == null) {
                temp.children[bit] = new TrieNode1();
            }
            // Move to the child node
            temp = temp.children[bit];
        }
        // At the leaf node, set count to 1 and sum to index + 1
        temp.count = 1;
        temp.sum = index + 1;
    }

    // Searches for a number (prefix XOR) in the trie and returns its current count and sum
    Pair1 search(int num, int index) {
        TrieNode1 temp = root1;
        // Process each bit from the most significant bit (30th) to the least (0th)
        for (int i = 30; i >= 0; i--) {
            // Extract the i-th bit
            int bit = (num >> i) & 1;
            // Return null if the path doesn't exist
            if (temp.children[bit] == null) {
                return null;
            }
            // Move to the child node
            temp = temp.children[bit];
        }
        // Create a pair with the current count and sum
        Pair1 pair = new Pair1(temp.count, temp.sum);
        // Update the node: increment count and add index + 1 to sum
        temp.count = temp.count + 1;
        temp.sum = temp.sum + index + 1;
        return pair;
    }

    // Helper class to store count and sum of indices for a prefix XOR
    class Pair1 {
        int count;
        int sum;

        Pair1(int x, int y) {
            count = x;
            sum = y;
        }
    }

    // Trie node class
    class TrieNode1 {
        TrieNode1[] children;
        int count;     // Number of occurrences of the prefix XOR
        int sum;       // Sum of (index + 1) for all occurrences

        TrieNode1() {
            children = new TrieNode1[2];  // Two children for bits 0 and 1
            count = 0;
            sum = 0;
        }
    }
}
