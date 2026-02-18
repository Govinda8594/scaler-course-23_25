package com.scaler.Scaler.Arrays;

public class MinimumTimeWorkerAlgo {
    static void main(String[] args) {
        // O(log high+low + 1 base 2 * N times)
        int ans = getminimumtimeWorkerCompleteWork(new int[]{1, 2, 3}, 2);
    }

    static int getminimumtimeWorkerCompleteWork(int[] time, int worker) {
        int low = 0, high = 0, ans = Integer.MAX_VALUE;
        for (int j : time) {
            low = Math.max(low, j);
        }
        for (int j : time) {
            high += j;
        }
        while (low <= high) {
            int midtimie = (low + high) / 2;
            if (check(time, worker, midtimie)) {
                ans = midtimie;
                high = midtimie - 1;
            } else
                low = midtimie + 1;

        }
        return ans;
    }

    private static boolean check(int[] time, int worker, int midtimie) {
        int total = 0, person = 1;
        for (int j : time) {
            total += j;
            if (total > midtimie) {
                person++;
                total = j;
            }
            if (person > worker) {
                return false;
            }
        }
        return true;
    }
}
