package com.scaler.Scaler.GreedyProblem;

import java.util.Arrays;

//N children are standing in a line. Each child is assigned a rating value.
//        You are giving candies to these children subjected to the following requirements:
//        Each child must have at least one candy.
//        Children with a higher rating get more candies than their neighbors.
//        What is the minimum number of candies you must give?
public class DistributeCandies {

    public int candy(int[] A) {
        int n = A.length;
        int[] candies = new int[n + 1];
        Arrays.fill(candies, 1);
        for (int i = 2; i <= n; i++) {
            if (A[i - 1] > A[i - 2])
                candies[i] = candies[i - 1] + 1;
        }
        for (int i = n - 1; i >= 1; i--) {
            if (A[i - 1] > A[i]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int s = 0;
        for (int i = 1; i <= n; i++) s += candies[i];
        return s;
    }
    /////////////////////////////////////////////////////////////////////////////

    public int candy2(int[] A) {
        int[] leftMin = makeLeftMin(A);
        int[] rightMin = makeRightMin(A);
        return compute(leftMin, rightMin);
    }

    public int[] makeLeftMin(int[] students) {
        int[] leftMin = new int[students.length];
        Arrays.fill(leftMin, 1);
        for (int i = 1; i < leftMin.length; i++) {
            if (students[i] > students[i - 1]) {
                leftMin[i] = leftMin[i - 1] + 1;
            }
        }
        return leftMin;
    }

    public int[] makeRightMin(int[] students) {
        int[] rightMin = new int[students.length];
        Arrays.fill(rightMin, 1);
        for (int i = rightMin.length - 2; i >= 0; i--) {
            if (students[i] > students[i + 1]) {
                rightMin[i] = rightMin[i + 1] + 1;
            }
        }
        return rightMin;
    }

    public int compute(int[] leftMin, int[] rightMin) {
        int ans = 0;
        for (int i = 0; i < leftMin.length; i++) {
            ans += Math.max(leftMin[i], rightMin[i]);
        }
        return ans;
    }
}
