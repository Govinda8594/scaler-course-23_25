package com.scaler.Scaler.DynamicProgramming.FindSumPattern;

import java.util.HashMap;
import java.util.Map;

public class NegativeSubset_With_K {
    //    Given a[N].Check if there exists a subset
    //    with sum K where every element can be picked zero or one times
    //    and element of array contain negative
    //    is less than 0 and position element. and sum k is positive integer
//    write a java code
    private static boolean backtrack(int[] a, int index, int currentSum, int target) {
        // Base case: if current sum equals target
        if (currentSum == target) return true;

        // If we've gone through all elements
        if (index == a.length) return false;

        // Pick current element
        boolean include = backtrack(a, index + 1, currentSum + a[index], target);

        // Skip current element
        boolean exclude = backtrack(a, index + 1, currentSum, target);

        return include || exclude;
    }

    static void main(String[] args) {
        int[] a = {-3, 5, -7, 2}; // All negative
        int k = 5; // Positive target
//        O(2)N
        System.out.println(backtrack(a, 0, 0, k)); // Output: false
    }

    /// ////////
    public static void main1(String[] args) {
        int[] a1 = {1, -1, 2};
        int k1 = 2;
        // Create memo map: key = index + "," + currentSum, value = boolean result
        Map<String, Boolean> memo = new HashMap<>();
//        O(N * (K + sum of abs of arr[i]))
        System.out.println("Top-Down [1,-1,2] k=2: " + isSubsetSum(a1, a1.length - 1, k1, memo)); // true
    }

    static boolean isSubsetSum(int[] set, int index, int sum, Map<String, Boolean> memo) {
        // Base case: end of array
        if (index < 0) return sum == 0;

        String key = index + "@" + sum;
        if (memo.containsKey(key)) return memo.get(key);

        // Option 1: Don't pick the current element
        boolean exclude = isSubsetSum(set, index - 1, sum, memo);

        // Option 2: Pick the current element (only once)
        boolean include = false;
        if (sum >= set[index]) {
            include = isSubsetSum(set, index - 1, sum - set[index], memo);
        }

        boolean result = exclude || include;
        memo.put(key, result);
        return result;
    }
}
