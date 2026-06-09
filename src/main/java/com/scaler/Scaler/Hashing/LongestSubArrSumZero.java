package com.scaler.Scaler.Hashing;

import java.util.HashMap;

public class LongestSubArrSumZero {
    static int longestSubArrayExistsSumZer0(long[] array) {
        int len = array.length;
        HashMap<Long, Integer> map = new HashMap<>();
        long[] prefix = new long[len];
        map.put(0L, -1);
        prefix[0] = array[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + array[i];
        }
        int maxlen = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(prefix[i])) {
                maxlen = Math.max(maxlen, i - map.get(prefix[i]));
            } else {
                map.put(prefix[i], i);
            }
        }
        return maxlen;
    }
}
