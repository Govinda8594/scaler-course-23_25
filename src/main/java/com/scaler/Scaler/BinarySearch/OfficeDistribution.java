package com.scaler.Scaler.BinarySearch;

//The government wants to set up B distribution offices across N cities for the distribution of food packets.
//        The population of the ith city is A[i]. Each city must have at least 1 office and every person is assigned to exactly one office in their own city.
//        Let M denote the minimum number of people that are assigned to any of the offices. Find the maximum value of M possible.
public class OfficeDistribution {

    int countOfShops(int[] A, int mid) {
        int count = 0;
        for (int j : A) {
            count += j / mid;
        }
        return count;
    }

    public int solve2(int[] A, int B) {

        long sum = 0;
        int min = A[0];
        for (int j : A) {
            sum += j;
            min = Math.min(min, j);
        }
        if (B > sum) return 0;
        int low = 1, high = min;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countOfShops(A, mid) >= B) {
                ans = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return ans;
    }
}
