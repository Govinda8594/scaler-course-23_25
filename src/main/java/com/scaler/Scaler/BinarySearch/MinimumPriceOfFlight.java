package com.scaler.Scaler.BinarySearch;

public class MinimumPriceOfFlight {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[] A, int B) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : A) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int low = min, high = max;
        while (low <= high) {
            int mid = (low + ((high - low) >> 1));
            int count = findCount(A, mid);
            if (count < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    int findCount(int[] A, int val) {
        int count = 0;
        for (int j : A) {
            if (j <= val) {
                count++;
            }
        }
        return count;
    }

}
