package com.scaler.Scaler.Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//Given an array A of length N. You have to answer Q queries.
//        Each query will contain four integers l1, r1, l2, and r2. If sorted segment from [l1, r1] is the same as the sorted segment from [l2 r2], then the answer is 1 else 0.
//        NOTE The queries are 0-indexed.
public class ComapreTwoSortedArray {
    public int[] comapreTwoSortedArray(int[] A, int[][] B) {
        HashSet<Integer> hashSet = new HashSet<>();
        int[] result = new int[B.length];
        int diff;
        int a, b;
        int l1, r1, l2, r2;
        for (int i = 0; i < B.length; i++) {
            l1 = B[i][0];
            r1 = B[i][1];
            l2 = B[i][2];
            r2 = B[i][3];
            diff = r2 - l2 + 1;
            a = 0;
            b = 0;
            for (int j = l1; j <= r1; j++) {
                hashSet.add(A[j]);
                if (hashSet.contains(A[j]) && A[l2] == A[j]) {
                    l2++;
                    a++;
                    hashSet.remove(A[j]);
                } else if (hashSet.contains(A[j]) && A[r2] == A[j]) {
                    r2--;
                    b++;
                    hashSet.remove(A[j]);
                } else {
                    break;
                }
            }
            if (diff == a + b) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    //////////////////////////////////////////////////////
    public int[] solve2(int[] A, int[][] B) {
        int k = 0;
        int[] ans = new int[B.length];
        for (int[] q : B) {
            int l1 = q[0], r1 = q[1], l2 = q[2], r2 = q[3];
            HashMap<Integer, Integer> map1 = new HashMap<>();
            HashMap<Integer, Integer> map2 = new HashMap<>();
            for (int i = l1; i <= r1; i++) {
                map1.put(A[i], map1.getOrDefault(A[i], 0) + 1);
            }
            for (int i = l2; i <= r2; i++) {
                map2.put(A[i], map2.getOrDefault(A[i], 0) + 1);
            }
            if (map1.equals(map2)) {
                ans[k++] = 1;
            } else {
                ans[k++] = 0;
            }
        }
        return ans;
    }
    /////////////////////////////////////////////////////////////////////////

    public int[] solve1(int[] A, int[][] B) {
        int k = 0;
        int[] ans = new int[B.length];
        for (int[] q : B) {
            int l1 = q[0], r1 = q[1], l2 = q[2], r2 = q[3];
            Arrays.parallelSort(A, l1, r1 + 1);
            Arrays.parallelSort(A, l2, r2 + 1);
            if (Arrays.equals(Arrays.copyOfRange(A, l1, r1 + 1), Arrays.copyOfRange(A, l2, r2 + 1))) {
                ans[k++] = 1;
            } else {
                ans[k++] = 0;
            }
        }
        return ans;
    }
}
