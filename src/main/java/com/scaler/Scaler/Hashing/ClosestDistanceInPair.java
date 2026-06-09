package com.scaler.Scaler.Hashing;

import java.util.HashMap;
//Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.
//        Shaggy wants you to find a special pair such that the distance between that pair is minimum. Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.
public class ClosestDistanceInPair {
    public int solve(int[] A) {
        HashMap<Integer, Integer> lastIdx = new HashMap<>();
        int len = A.length, ans = Integer.MAX_VALUE;
        for (int i : A) {
            lastIdx.put(i, -1);
        }
        for (int i = 0; i <= len - 1; i++) {
            if (lastIdx.get(A[i]) != -1) {
                ans = Math.min(ans, i - lastIdx.get(A[i]));
            }
            lastIdx.put(A[i], i);
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}
