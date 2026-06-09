package com.scaler.Scaler.Hashing;

import java.util.HashMap;

//You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
//        Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
//        NOTE: if B > N, return an empty array.
public class DistinctElementInWindow {
    public int[] dNums(int[] A, int B) {
        if (B > A.length) {
            return new int[0];
        }
        //Using HashMap and sliding window together
        int[] ans = new int[A.length - B + 1];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < B; i++) {
            if (hm.containsKey(A[i])) {
                hm.put(A[i], hm.get(A[i]) + 1);
            } else {
                hm.put(A[i], 1);
            }
        }
        ans[0] = hm.size();
        int s = 1, e = B;
        while (e < A.length) {
            hm.put(A[s - 1], hm.get(A[s - 1]) - 1);
            if (hm.get(A[s - 1]) == 0) {
                hm.remove(A[s - 1]);
            }
            if (hm.containsKey(A[e])) {
                hm.put(A[e], hm.get(A[e]) + 1);
            } else {
                hm.put(A[e], 1);
            }
            ans[s] = hm.size();
            s++;
            e++;
        }
        return ans;
    }
}
