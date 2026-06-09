package com.scaler.Scaler.Hashing;

import java.util.HashMap;
import java.util.HashSet;

//Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
//        If the given array contains a sub-array with sum zero return 1, else return 0.
public class SubArraySumZero {
    public static void main(String[] args) {
    }

    static boolean checkSubArrayExistsSumZer0(long[] array) {
        int len = array.length;
        HashSet<Long> set = new HashSet<Long>();
        long[] prefix = new long[len];
        set.add(0L);
        set.add(array[0]);
        prefix[0] = array[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + array[i];
            if (set.contains(prefix[i])) {
                return true;
            } else {
                set.add(prefix[i]);
            }
        }
        return false;
    }


    static boolean checkSubArrayExistsSum2Zer0(long[] array) {
        int len = array.length;
        HashSet<Long> set = new HashSet<Long>();
        long[] prefix = new long[len];
        // if pf array has repeated element subarry exist
        // if 0 present in pf subarray zero exist
//        set.add(0L);
//        set.add(array[0]);
        prefix[0] = array[0];
        for(int i = 1;i<len;i++)
            prefix[i] = prefix[i - 1] + array[i];
        for (int i = 0; i < len; i++) {
            if (prefix[i] == 0)
                return true;
                set.add(prefix[i]);
            }
            if (set.size() < len) return true;
            return false;
    }

    ////////////////////////////////////////////////////////////////////////////
    // Initialization code is already written and hidden from you. Do not write code for it again.
    public int solve(int[] A) {
        HashMap<Long, Integer> map = new HashMap<>();
        long preSum = 0;
        for (int i : A) {
            preSum += i;
            if (map.containsKey(preSum)) {
                return 1;
            }
            if (preSum == 0) {
                return 1;
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return 0;
    }
}
