package com.scaler.Scaler.Hashing;

import java.util.TreeMap;

public class MaxElementInWindow {
    public static int[] maxInWindow2(int[] A, int k) {
        int n = A.length;
        int[] result = new int[n - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        result[0] = map.lastKey();
        for (int i = k; i < n; i++) {
            int count = map.get(A[i - k]);
            if (count == 1) {
                map.remove(A[i - k]);
            } else {
                map.put(A[i - k], count - 1);
            }
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            result[i - k + 1] = map.lastKey();
        }
        return result;
    }
}
