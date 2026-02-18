package com.scaler.Scaler.Hashing;

import java.util.HashMap;

public class MaxiumDistinctElementInWindowKSize {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 1, 3, 4, 3};
        int[] ans = dNums(A, 3);
    }

    public static int[] dNums(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = A.length;
        int[] ans = new int[len - B + 1];
        for (int i = 0; i < B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        ans[0] = map.size();
        int start = 1, end = B;
        while (end < len) {
            int key = A[start - 1];
            int val = map.get(key);
            map.put(key, val - 1);
            if (map.get(key) == 0) {
                map.remove(key);
            }
            key = A[end];
            map.put(key, map.getOrDefault(key, 0) + 1);
            ans[start] = map.size();
            start++;
            end++;
        }
        return ans;
    }

    public int[] dNums2(int[] A, int B) {
        if (B > A.length) {
            return new int[0];
        }
        //Using HashMap and sliding window together
        int ans[] = new int[A.length - B + 1];
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
