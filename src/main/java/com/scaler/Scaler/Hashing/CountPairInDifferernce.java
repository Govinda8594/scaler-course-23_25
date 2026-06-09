package com.scaler.Scaler.Hashing;

import java.util.HashMap;

public class CountPairInDifferernce {

    ////////////////////////////////////////////////////////////////////////
    public static int countpairInDifference(int[] A, int B) {
        int size = A.length;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        long count = 0, mod = 1000000007;
        for (int j : A) {
            count += sumMap.getOrDefault(j - B, 0) + sumMap.getOrDefault(j + B, 0);
            sumMap.put(j, sumMap.getOrDefault(j, 0) + 1);
        }
        return (int) (count % mod);
    }

    public int countpairInDifference2(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int j : A) {
            int a = j + B;
            int b = j - B;
            if (map.containsKey(a)) count += map.get(a);
            if (map.containsKey(b)) count += map.get(b);
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        return count % 1000000007;
    }


    ///////////////////////////////////////////////////////////////////////
//    public int solve(int[] A, int B) {
//        Arrays.sort(A);
//        int n = A.length;
//        int i = 0, j = 1;
//        int diff = Integer.MIN_VALUE;
//        // Use HashMap to store unique pairs & discard repeated pairs
//        HashMap<Integer, Integer> hm = new HashMap<>();
//        while (i < n && j < n) {
//            diff = A[j] - A[i];
//            if (diff < B) {
//                j++;
//            } else if (diff > B) {
//                i++;
//            } else {
//                if (i != j) {
//                    hm.put(A[i], A[j]);
//                }
//                i++;
//            }
//        }
//        return hm.size();
//    }
}
