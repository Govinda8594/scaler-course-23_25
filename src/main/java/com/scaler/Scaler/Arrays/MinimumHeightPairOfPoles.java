package com.scaler.Scaler.Arrays;

public class MinimumHeightPairOfPoles {

//    Pair of poles
//
//    Given arr[N] denoting height of N poles
//    Connect two poles such that the all poles between them have height smaller than the minimum height of two poles. find the total length no of pair such poles
//
//    write a java code solution  for above problem statment

//    o solve this problem, we can use the following approach:
//
//    Initialize a variable ans to 0 to store the total length of the pair of poles.
//    Iterate over the array from left to right and find the minimum height of the two poles.
//    Iterate over the array from right to left and find the minimum height of the two poles.
//    Iterate over the array from left to right and check if the current pole has a smaller height than its adjacent poles. If so, add the length of the pair of poles to ans.
//    Return ans.
//    Here is the Java code that implements the above approach:
        public int pairOfPoles(int[] poles) {
            int N = poles.length;
            int ans = 0;
            for (int i = 0; i < N; i++) {
                int leftMin = Integer.MAX_VALUE;
                for (int j = i - 1; j >= 0; j--) {
                    leftMin = Math.min(leftMin, poles[j]);
                }
                int rightMin = Integer.MAX_VALUE;
                for (int j = i + 1; j < N; j++) {
                    rightMin = Math.min(rightMin, poles[j]);
                }
                if (poles[i] < leftMin && poles[i] < rightMin) {
                    ans += Math.min(leftMin, rightMin) - poles[i];
                }
            }
            return ans;
        }
}
