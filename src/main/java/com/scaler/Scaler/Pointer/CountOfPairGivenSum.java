package com.scaler.Scaler.Pointer;
//Given a sorted array of distinct integers A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
public class CountOfPairGivenSum {
    public int solve(int[] A, int B) {
        int i = 0;
        int j = A.length - 1;
        int count = 0;
        while (i != j && i < j) {
            int sum = A[i] + A[j];
            if (sum == B) {
                count++;
                i++;
                j--;
            } else if (sum < B) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
    ///////////////////////////////////////////////////
    public int solve2(int[] a, int b) {
        int ans = 0, l = 0, r = a.length - 1;
        while (l < r) {
            if (a[l] + a[r] == b) {
                ans++;
            }
            if (a[l] + a[r] <= b) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
