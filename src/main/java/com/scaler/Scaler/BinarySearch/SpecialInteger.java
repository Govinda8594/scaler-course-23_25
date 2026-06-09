package com.scaler.Scaler.BinarySearch;

//Given an array of integers A and an integer B,
// find and return the maximum value K
// uch that there is no subarray in A of size K with the sum of elements greater than B.
public class SpecialInteger {

    public static boolean check(int m, int[] A, int B, int n) {
        long sum = 0;

        for (int i = 0; i < m; i++) {
            sum = sum + A[i];
        }

        if (sum > B) {
            return false;
        }

        int start = 1;
        int end = m;
        while (end < n) {
            sum = sum - A[start - 1] + A[end];
            if (sum > B) {
                return false;
            }
            start++;
            end++;
        }

        return true;
    }
    ///////////////////////////////////////////////////////////////////////////

    public int solve(int[] A, int B) {
        int i = 0, j = 0, sum = 0, n = A.length, ans = n;
        while (j <= n) {
            if (sum <= B && j == n) break;
            if (sum <= B) {
                sum += A[j++];
            } else {
                sum -= A[i++];
                ans = Math.min(ans, j - i);
            }
        }
        return ans;
    }

    public int solve2(int[] A, int B) {
        int n = A.length;
        int l = 0;
        int r = n;
        int ans = l;

        while (l <= r) {
            int m = (r + l) / 2;
            if (check(m, A, B, n)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return ans;
    }
}
