package com.scaler.Scaler.Arrays;

//Given an array of non-negative integers A where each element represents your maximum jump length at that position.
//        The initial position is the first index of the array, and the goal is to reach the last index of the array with the minimum number of jumps.
//        Note: If it is not possible to reach the last index, return -1 instead.
public class MinimumNoOfJumps {
    public int solve(int[] A) {
        int len = A.length, current = 0, far = 0, jump = 0;
        for (int i = 0; i < len; i++) {
            if (far < i) {
                return -1;
            }
            far = Math.max(far, i + A[i]);
            if (current == i && i != len - 1) {
                current = far;
                jump++;
            }

        }
        return jump;
    }

    public int solve2(int[] A) {
        int n = A.length, jumps = 0, step = 0, jumpSoFar = 0;
        for (int i = 0; i < n - 1; i++) {
            jumpSoFar = Math.max(jumpSoFar, i + A[i]); // max jump can be taken so far
            if (i == step) { // step reach to index i
                jumps++;
                step = jumpSoFar; // update reach to index so far
                if (step >= n - 1) break;
            }
        }
        // not able to reach  -1
        return step < n - 1 ? -1 : jumps;
    }
}
