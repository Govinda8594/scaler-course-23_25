package com.scaler.Scaler.Pointer;

import java.util.Arrays;
//Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
//        Assume that there will only be one solution.
public class TripletClosestSum {
    static int tripletSum(int[] A, int B) {
        int bestdistance = Integer.MAX_VALUE, bestSum = -1;
        Arrays.sort(A);
        int len = A.length;
        for (int i = 0; i < len; i++) {
            int j = i + 1, k = len - 1;
            while (j < k) {
                int currSum = A[i] + A[j] + A[k];
                int currDistance = Math.abs(currSum - B);
                if (currDistance < bestdistance) {
                    bestdistance = currDistance;
                    bestSum = currSum;
                } else if (currSum < B) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return bestSum;
    }
    /////////////////////////////////////////////////////////////////////////////////

    public int threeSumClosest(int[] A, int B) {
        int n = A.length, diff = 1000000000, ans = -1;
        Arrays.sort(A);
        // fix the smallest number of the three integers
        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (Math.abs(A[i] + A[j] + A[k] - B) < diff) {
                    diff = Math.abs(A[i] + A[j] + A[k] - B);
                    ans = A[i] + A[j] + A[k];
                }
                if (A[i] + A[j] + A[k] > B) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}
