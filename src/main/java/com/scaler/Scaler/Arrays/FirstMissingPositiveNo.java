package com.scaler.Scaler.Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class FirstMissingPositiveNo {
    public static void main(String[] args) {
        firstMissingPositive(new int[]{3, 4, -1, 1});
    }

    static int firstMissingPositive1(int[] A) {
        int len = A.length;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int j : A) {
            set.add(j);
        }

        for (int i = 1; i <= len; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return len + 1;
    }

    public static int firstMissing(int[] A, int n) {
        // Write your code here.
        Arrays.sort(A);
        int i = 0, previous = 0, ans = 0;
        while (i < n) {
            if (A[i] > 0) {
                if (A[i] == previous + 1)
                    previous += 1;
                else {
                    ans = previous += 1;
                    break;
                }
            }
            i++;
            if (i == n - 1)
                ans = previous += 1;
        }
        return ans;
    }

    public static int firstMissingPositive(int[] A) {
        int n = A.length; // Get the length of the input array
        int val = 0; // Initialize a variable to store the current value

        // Place each element at its correct position in the array
        for (int i = 0; i < n; i++) {
            // While the element is positive, within the array bounds, and not at its correct position
            while (A[i] > 0 && A[i] <= n && A[i] != (i + 1)) {
                val = A[i]; // Store the current value
                if (A[i] == A[val - 1]) // If the current value is already in its correct position, break the loop
                    break;
                A[i] = A[val - 1]; // Swap the current element with the element at its correct position
                A[val - 1] = val; // Place the current value at its correct position
            }
        }

        // Find the first missing positive integer
        for (int j = 0; j < n; j++) {
            // If an element is not at its correct position, return the expected value
            if (A[j] != j + 1) {
                return j + 1; // Return the first missing positive integer
            }
        }
        return n + 1; // If all elements are in their correct positions, return n + 1
    }


}
