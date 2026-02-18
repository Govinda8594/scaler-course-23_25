package com.scaler.Scaler.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestSubsetDivisible {
//    divisible subset,
//    every larger number in the subset must be exactly divisible by the smaller one.

    static void main(String[] args) {
        LargestSubsetDivisible largestSubsetDivisible = new LargestSubsetDivisible();
        largestSubsetDivisible.largestDivisibleSubset(new int[]{4, 8, 4, 12, 52});
    }

    public ArrayList<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return new ArrayList<>(); // Return an empty list if the array is empty

        // Step 1: Sort the array in descending order to get lexicographically largest answer

        Arrays.sort(arr); // Sort in ascending order
        // Reverse to get descending order
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        // Step 2: Create DP and tracking arrays
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);    // Each element is a subset of size 1
        Arrays.fill(prev, -1); // Initialize previous index array

        int maxIdx = 0, maxSize = 1;

        // Step 3: Fill DP array to track the largest subset ending at each index
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[j] % arr[i] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j; // Track the previous element index ,that is picked for subset
                }
            }
            // Keep track of the index of the largest subset found,largest size
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIdx = i;
            }
        }

        // Step 4: Reconstruct the largest divisible subset
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = maxIdx; i >= 0; i = prev[i]) {
            answer.add(arr[i]);
            if (prev[i] == i)
                break; // backtrack until there are no more previous elements
        }

        return answer; // Return the result in descending order
    }
}
