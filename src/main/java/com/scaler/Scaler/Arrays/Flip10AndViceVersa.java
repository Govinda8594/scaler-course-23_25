package com.scaler.Scaler.Arrays;

//You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN.
// In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and
// flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.
//        Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
//        If you don't want to perform the operation, return an empty array.
//        Else, return an array consisting of two elements denoting L and R. If there are multiple solutions,
//        return the lexicographically smallest pair of L and R.
//        NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
public class Flip10AndViceVersa {
    public static void main(String[] args) {
        flip("010");
        // 010
    }
//    kanaden's alogritmn'
    public static int[] flip(String A) {
        int n = A.length();
        int[] arr = new int[n];

        // Convert string into +1/-1 array
        for (int i = 0; i < n; i++) {
            arr[i] = (A.charAt(i) == '0') ? 1 : -1;
        }

        int maxSum = 0, currSum = 0;
        int start = 0, bestL = -1, bestR = -1;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            if (currSum > maxSum) {
                maxSum = currSum;
                bestL = start;
                bestR = i;
            }

            if (currSum < 0) {
                currSum = 0;
                start = i + 1;
            }
        }

        // Edge case: if no beneficial flip
        if (bestL == -1) return new int[]{};

        // Return indices (0-based here, can shift to 1-based if needed)
        return new int[]{bestL + 1, bestR + 1};
    }

    public int[] flip2(String A) {
        int n = A.length();
        int maxSum = 0, currSum = 0;
        int start = 0, bestL = -1, bestR = -1;

        for (int i = 0; i < n; i++) {
            // Contribution: +1 for '0', -1 for '1'
            int val = (A.charAt(i) == '0') ? 1 : -1;
            currSum += val;

            if (currSum > maxSum) {
                maxSum = currSum;
                bestL = start;
                bestR = i;
            }

            if (currSum < 0) {
                currSum = 0;
                start = i + 1;
            }
        }

        // Edge case: if no beneficial flip
        if (bestL == -1) return new int[]{};

        // Return 1-based indices
        return new int[]{bestL + 1, bestR + 1};
    }
}
