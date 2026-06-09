package com.scaler.Scaler.Hashing;
//Given an unsorted integer array A of size N.
//        Find the length of the longest set of consecutive elements from array A.

import java.util.HashMap;
import java.util.HashSet;

public class LongestconsecutiveSubArray {
    public static void main(String[] args) {
//        longestconsecutiveLength(new int[]{2,1,4,203,204,3,200,201,202,});
        longestconsecutiveLength(new int[]{21, 144, 49, 74, 48, 107, 54, 66, 18, 93, 64, 50, 92, 39, 37, 70, -2, 117, 72, 40, 87, 35, 79, 52, 44, 4, 38, 84, 25, 113, 106, 32, 27, 57, 68, 45, 9, 29, 100, 5, 13, 58, 105, 77, 78, 43, 20, 24, 94, 111, 53});
    }

    static int longestconsecutiveLength(int[] A) {
        int len = A.length, maxlen = 0;
        if (len == 1) {
            return 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(A[i], i);
        }
        for (int j : A) {
            int copy = j;
            if (!map.containsKey(copy - 1)) {  // terminate/starting new sequence ,previous num should not be there to start new sequence
                int count = 1;
                while (map.containsKey(copy + 1)) {
                    copy++;
                    count++;
                }
                maxlen = Math.max(maxlen, count);
            }
        }
        return maxlen;
    }

    ///////////////////////////////////////////////////////////////////////////////
    public int longestConsecutive(final int[] A) {
        int ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i : A) {
            hs.add(i);
        }
        for (Integer x : hs) {
            if (!hs.contains(x - 1)) {
                int size = 0;
                Integer y = x;
                while (hs.contains(y)) {
                    size++;
                    y++;
                }
                ans = Math.max(ans, size);
            }
        }
        return ans;
    }
}
