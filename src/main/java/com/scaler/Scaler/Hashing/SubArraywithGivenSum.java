package com.scaler.Scaler.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class SubArraywithGivenSum {
    public int[] subArrayWithGivenSum(int[] A, int B) {
        long val = 0;
        int len = A.length;
        HashMap<Long, Integer> hm = new HashMap<>();
        long[] prefix = new long[len];
        prefix[0] = A[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + A[i];
        }
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            if (prefix[i] == (long) B) {
                end = i;
                return Arrays.copyOfRange(A, start, end + 1);
            }// subarray from [0....j]
            val = prefix[i] - (long) B; // subarray from [i....j] ==> prefix[i - 1] = prefix[j] - B
            if (hm.containsKey(val)) { // search on left side
                start = hm.get(val) + 1;
                end = i;
                return Arrays.copyOfRange(A, start, end + 1); // instance of subarray from [i...j] ==> which is equal to B
            }
            if (hm.containsKey(prefix[i])) {
            } else {
                hm.put(prefix[i], i);
            }
        }
        return new int[]{-1};
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    public int[] solve(int[] A, int B) {
        int len = A.length;
        int start = 0, end = 0;
        int sum = A[start];
        while (end < len && start <= end) {
            if (sum == B) {
                return Arrays.copyOfRange(A, start, end + 1);
            } else if (sum < B) {
                end++;
                if (end < len)
                    sum += A[end];
            } else {
                sum -= A[start];
                start++;
                if (start > end && start <= len - 1) {
                    end++;
                    sum += A[end];
                }
            }
        }
        return new int[]{-1};
    }
}
