package com.scaler.Scaler.GreedyProblem;

import java.util.Arrays;

//There are N jobs to be done, but you can do only one job at a time.
//        Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
//        Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
//        Return the maximum number of jobs you can finish.
public class MaximumJobs {

    public static void main(String[] args) {
        solve(new int[]{1, 5, 7, 1,}, new int[]{7, 8, 8, 8});
    }

    public static int solve(int[] A, int[] B) {
        int n = A.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i] = new int[]{A[i], B[i]};
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int endTime = pair[0][1];
        for (int i = 1; i < n; i++) {
            if (pair[i][0] >= endTime) {//escaping conflicts
                endTime = pair[i][1];
                count++;
            }
        }
        return count;
    }
}
