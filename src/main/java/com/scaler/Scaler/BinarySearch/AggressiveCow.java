package com.scaler.Scaler.BinarySearch;

import java.util.Arrays;

//Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
//
//        His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
public class AggressiveCow {

    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int N = A.length;
        int low = 1, high = A[N - 1] - A[0], ans = 0;
        while (low <= high) {
            int mid = ((low + high) >> 1);
            if (check(A, mid, B)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int[] A, int mid, int B) {
        int previousCow = A[0];
        int totalCows = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - previousCow >= mid) {
                totalCows++;
                previousCow = A[i];
                if (totalCows == B) {
                    return true;
                }
            }
        }
        return false;
    }
    ////////////////////////////////////////////////////////////////

    public boolean check(int x, int[] A, int c) {
        int j = 0, n = A.length;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] - A[j] >= x) {
                j = i;
                cnt++;
            }
        }
        return (cnt >= c);
    }

    public int solve2(int[] A, int B) {
        Arrays.sort(A);
        int l = 1, r = 1000 * 1000 * 1000;
        int ans = 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid, A, B)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
