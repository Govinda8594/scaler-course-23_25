package com.scaler.Scaler.Pointer;

import java.util.ArrayList;

public class CountRectangle {
    public int solve(int[] A, int B) {
        int len = A.length - 1, left = 0, right = len, count = 0;
        while (left <= len && right >= 0) {
            long area = (long) A[left] * A[right];
            if (area < B) {
                count += (right + 1);
                count = count % 1000000007;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    public int solve(ArrayList<Integer> A, int B) {
        long ans = 0, mod = (long) (1000000000 + 7);
        int l = 0, r = A.size() - 1;
        while (l < A.size() && r >= 0) {
            if ((long) A.get(l) * A.get(r) < B) {
                // A[l] can form rectangles with any of A[0..r]
                ans = (ans + r + 1) % mod;
                l++;
            } else {
                r--;
            }
        }
        return (int) ans;
    }
}
