package com.scaler.Scaler.Pointer;
//Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
//        Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
public class PairWithGivenSumBLarge {

    public int solve(int[] A, int B) {
        int n = A.length;
        int p1 = 0;
        int p2 = n - 1;
        long count = 0;
        long mod = 1000000007;
        while (p1 < p2) {
            if (A[p1] + A[p2] > B) {
                p2--;
            } else if (A[p1] + A[p2] < B) {
                p1++;
            } else {
                if (A[p1] == A[p2]) {
                    long dupCount = p2 - p1 + 1;
                    count = count + (dupCount * (dupCount - 1) / 2);
                    break;
                } else {
                    int leftCount = 0;
                    int rightCount = 0;
                    int x = A[p1];
                    int y = A[p2];
                    while (A[p1] == x) {
                        leftCount++;
                        p1++;
                    }
                    while (A[p2] == y) {
                        rightCount++;
                        p2--;
                    }
                    count = count + ((long) leftCount * rightCount);
                }
            }
        }
        count %= mod;
        return (int) count;
    }
}
