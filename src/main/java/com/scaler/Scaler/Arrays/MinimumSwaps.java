package com.scaler.Scaler.Arrays;

public class MinimumSwaps {
    public static void main(String[] args) {
//        int swaps = minimumSwaps(new int[]{1, 12, 10, 3, 14,10,5},8 );
//        int swaps = minimumSwaps(new int[]{5, 17, 100, 11},20 );
        int minElementWindowSize = minimumSwaps(new int[]{52, 7, 44, 5, 41, 19, 17, 13, 5, 84, 3, 16, 83, 9, 29, 7, 11, 70}, 19);
    }

    static int minimumSwaps(int[] A, int B) {
        int minElementWindowSize = 0;
        int len = A.length;

        for (int j : A) {
            if (j <= B)
                minElementWindowSize++;
        }
        if (minElementWindowSize <= 1)
            return 0;
        int badElement = 0;
        for (int i = 0; i < minElementWindowSize; i++) {
            if (A[i] > B)
                badElement++;
        }

        int ans = badElement;
        int s = 1, e = minElementWindowSize;
        while (e < len) {
            if (A[s - 1] > B) badElement--;
            if (A[e] > B) badElement++;
            ans = Math.min(ans, badElement);
            s++;
            e++;
        }
        return ans;
    }
}
