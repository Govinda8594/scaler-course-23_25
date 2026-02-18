package com.scaler.Scaler.Hashing;

import java.util.HashMap;

public class CountSubArraywithGivenKSum {

    public static void main(String[] args) {
        countofSubArraySumK3(new int[]{17, 3, 14, 17, 7, 10, -7, -11}, -17);
    }

    ////not working
    public static int countofSubArraySumK3(int[] A, int B) {
        int count = 0, val = 0, len = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] prefix = new int[len];
        prefix[0] = A[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + A[i];
        }
        for (int i = len - 1; i >= 0; i--) {
            if (prefix[i] == B) {
                count++; // subarray from [0....j]
            }
            val = B + prefix[i]; // subarray from [i....j] ==> prefix[j] = prefix[i -1] + B
            if (hm.containsKey(val)) { // search on right side
                count += hm.get(val); // instance of subarray from [i...j] ==> which is equal to B
            }
            hm.put(prefix[i], hm.getOrDefault(prefix[i], 0) + 1);
        }
        return count;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    public int countofSubArraySumK(int[] A, int B) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int preFix = 0;
        for (int j : A) {
            preFix += j;
            if (hm.containsKey(preFix - B)) {
                count += hm.get(preFix - B);
            }
            hm.put(preFix, hm.getOrDefault(preFix, 0) + 1);
        }
        return count;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public int countofSubArraySumK2(int[] A, int B) {
        int count = 0, val = 0, len = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] prefix = new int[len];
        prefix[0] = A[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + A[i];
        }
        for (int i = 0; i < len; i++) {
            if (prefix[i] == B) {
                count++; // subarray from [0....j]
            }
            val = prefix[i] - B; // subarray from [i....j] ==> prefix[i - 1] = prefix[j] - B
            if (hm.containsKey(val)) { // search on left side
                count += hm.get(val); // instance of subarray from [i...j] ==> which is equal to B
            }
            hm.put(prefix[i], hm.getOrDefault(prefix[i], 0) + 1);
        }
        return count;
    }

//    public int solve(int[] A, int B, int C) {
//        int len = A.length;
//        int sum = 0;
//        for (int i = 0; i < B; i++) {
//            sum += A[i];
//        }
//        int s = 1, e = B;
//        if (len == s) {
//            if (sum == C) {
//                return 1;
//            }
//        }
//        while (e < len) {
//            if (sum == C) {
//                return 1;
//            }
//            sum = sum - A[s - 1] + A[e];
//            s++;
//            e++;
//        }
//        return 0;
//    }
}
