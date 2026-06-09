package com.scaler.Scaler.Hashing;

import java.util.HashMap;

//Given an array A of N integers.
//Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7
public class CountSubArrayZer0Sum {

    public static void main(String[] args) {
        countSubArraySumZero(new int[]{0, -2, 6, -1, 3, -1});

    }

    public static int countSubArraySumZero(int[] A) {
        HashMap<Long, Integer> hm = new HashMap<>();
        int count = 0;
        long pfsum = 0;
        hm.put(0L, 1);
        for (int j : A) {
            pfsum = pfsum + j;
            if (hm.containsKey(pfsum)) {
                count += hm.get(pfsum);
            }
            hm.put(pfsum, hm.getOrDefault(pfsum, 0) + 1);
        }
        return count % 1000000007;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve(int[] A) {
        int count = 0, val = 0, len = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] prefix = new int[len];
        prefix[0] = A[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + A[i];
        }
        for (int i = 0; i < len; i++) {
            if (prefix[i] == 0) {
                count++; // subarray from [0....j]
            }
            val = prefix[i]; // subarray from [i....j] ==> prefix[i - 1] = prefix[j] - B
            if (hm.containsKey(val)) { // search on left side
                count += hm.get(val); // instance of subarray from [i...j] ==> which is equal to B
            }
            hm.put(prefix[i], hm.getOrDefault(prefix[i], 0) + 1);
        }
        return count % 1000000007;
    }
}
