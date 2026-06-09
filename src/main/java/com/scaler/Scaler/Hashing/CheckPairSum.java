package com.scaler.Scaler.Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class CheckPairSum {

    public int checkPairSum(int A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : B) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : B) {
            int b = A - i;
            if (i != b && map.containsKey(b))
                return 1;
            if (i == b && map.get(i) > 1)
                return 1;
        }
        return 0;
    }

    public int checkPairSum1(int A, int[] B) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        for (int j : B) {
            if (sumMap.containsKey(A - j)) {
                return 1;
            }
            sumMap.put(j, sumMap.getOrDefault(j, 0) + 1);
        }
        return 0;
    }

    boolean checkPairSumK(int[] A, int B) {
        int val = 0, len = A.length;
        int[] prefix = new int[len];
        prefix[0] = A[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + A[i];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = len - 1; i >= 0; i--) {
            int target = B + A[i];
            if (set.contains(target)) {
                return true;
            }
            set.add(A[i]);
        }
        return set.contains(B);
    }

}
