package com.scaler.Scaler.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class CheckPairInDifferernce {

    public int CheckPairInDifferernce1(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int j : A) {
            int a = j + B;
            int b = j - B;
            if (map.containsKey(a)) {
                return 1;
            }
            if (map.containsKey(b)) {
                return 1;
            }
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        return 0;
    }

    public int CheckPairInDifferernce2(int[] A, int k) {
        Arrays.sort(A);
        int len = A.length;
        if (k < 0) k = k * -1;
        int ptr1 = 0, ptr2 = 1;
        while (ptr2 < len && ptr1 != ptr2) {
            if (A[ptr2] - A[ptr1] == k) {
                return 1;
            } else if (A[ptr2] - A[ptr1] > k) {
                ptr1++;
                if (ptr1 == ptr2) ptr2++;
            } else ptr2++;
        }
        return 0;
    }
}
