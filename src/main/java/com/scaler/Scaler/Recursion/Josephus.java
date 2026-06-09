package com.scaler.Scaler.Recursion;

public class Josephus {
    //    Given the total number of person A and a number B which indicates that B-1 persons are skipped and the Bth person is killed in a circle. Find the last person standing in the circle. As an example, for A = 12, and B = 2,
    public static void main(String[] args) {
        int ans = recursive(2, 2);
    }

    static int recursive(int A, int B) {
        if (A == 1) return 1;
        int next = recursive(A - 1, B);
        // ((next + B - 1) will have knife and kill Bth person) % i(for range of A) + 1(convert 1-based indexing)
        return (next + B - 1) % A + 1;
    }

    static int recursive1(int A, int B) {
        if (A == 0) return 0;  // Edge case: no people
        int ans = 0;           // Base solution for n=1 (0-indexed)

        // Iterate from 2 to A to compute Josephus position
        for (int i = 2; i <= A; i++) {
            // Update answer using recurrence: f(i) = [f(i-1) + B] % i
            ans = (ans + B) % i;
        }
        return ans + 1;  // Convert 0-indexed result to 1-indexed
    }

    int iterative(int A, int B) {
        if (A == 0) return 0; // Edge case: no people
        int ans = 1; // Base solution for n=1 (1-indexed)
        for (int i = 2; i <= A; i++) {
            // ((ans + B - 1) will have knife and kill Bth person) % i(for range of A) + 1(convert 1-based indexing)
            ans = (ans + B - 1) % i + 1;
        }
        return ans;
    }
}

