package com.scaler.Scaler.Arrays;

public class MaximumAbsDifference2 {

    static int maxABSDifference(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length, ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                ans = Math.max(ans, Math.abs(A[i] - A[j]) + Math.abs(B[i] - B[j]) + Math.abs(C[i] - C[j]) + Math.abs(D[i] - D[j])
                        + Math.abs(i - j));
            }
        }
        return ans;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static int maxABSDifferenceOptimize(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length; // Get the length of the input arrays
        int ans = 0; // Initialize the answer to 0

        for (int i = 0; i < 32; i++) { // Iterate through 32 combinations (2^5 = 32)
            int maxI = Integer.MIN_VALUE; // Initialize maximum value for current combination
            int minI = Integer.MAX_VALUE; // Initialize minimum value for current combination

            for (int j = 0; j < len; j++) { // Iterate through each element in the arrays
                int curr = A[j]; // Start with the element from array A

                for (int k = 0; k < 4; k++) { // Iterate through the 4 elements to add or subtract
                    int temp; // Initialize temp to store value from B, C, D, or index j
                    if (k == 0) temp = B[j]; // First element from array B
                    else if (k == 1) temp = C[j]; // Second element from array C
                    else if (k == 2) temp = D[j]; // Third element from array D
                    else temp = j; // Fourth element is the index j

                    // Check if the k-th bit in i is set and add or subtract temp accordingly
                    if ((i & (1 << k)) == 1) {
                        curr += temp;
                    } else {
                        curr -= temp;
                    }
                }

                // Update maximum and minimum values for the current combination
                maxI = Math.max(maxI, curr);
                minI = Math.min(minI, curr);
            }

            // Update the answer with the maximum absolute difference for the current combination
            ans = Math.max(ans, maxI - minI);
        }

        // Return the final maximum absolute difference
        return ans;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve(int[] A, int[] B, int[] C, int[] D) {
        int[] m = new int[5]; // Array to store the signs (+1 or -1) for each combination
        int val = 0, ans = 0; // Initialize val to store the calculated value and ans to store the final answer

        // Expand the given expression in 32 different ways
        for (int i = 0; i < 32; i++) { // Iterate through 32 combinations (2^5 = 32)
            for (int j = 0; j < 5; j++) { // Iterate through 5 elements to set signs
                m[j] = ((i >> j) & 1); // Get the j-th bit of i
                if (m[j] == 0) m[j] = -1; // If the j-th bit is 0, set m[j] to -1; otherwise, it remains 1
            }

            int Min = Integer.MAX_VALUE; // Initialize the minimum value for the current combination
            int Max = Integer.MIN_VALUE; // Initialize the maximum value for the current combination

            for (int k = 0; k < A.length; k++) { // Iterate through each element in the arrays
                // Calculate the value using the current combination of signs
                val = A[k] * m[0] + B[k] * m[1] + C[k] * m[2] + D[k] * m[3] + k * m[4];

                // Update the maximum and minimum values for the current combination
                Max = Math.max(Max, val);
                Min = Math.min(Min, val);
            }

            // Update the answer with the maximum difference for the current combination
            ans = Math.max(ans, Max - Min);
        }

        return ans; // Return the final answer
    }
}
