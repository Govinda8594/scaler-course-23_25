package com.scaler.Scaler.Arrays;

//There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.
//        Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
//        For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B

public class KBeggerSumQuery {
    public static void main(String[] args) {
        KBeggerSumQueryOptimize(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
    }

    static int[] KBeggerSumQuery(int[][] query, int A) {
        int[] pf = new int[A];
        for (int[] ints : query) {
            int l = ints[0];
            int r = ints[1];
            int val = ints[2];
            for (int j = l - 1; j < r; j++) {
                pf[j] += val;
            }
        }
        return pf;
    }

    static int[] KBeggerSumQueryOptimize(int[][] query, int A) {
        int[] pf = new int[A];
        for (int[] ints : query) {
            int l = ints[0];
            int r = ints[1];
            int val = ints[2];
            pf[l - 1] += val;
            if (r < A) {
                pf[r] -= val;
            }
        }
        for (int i = 1; i < A; i++) {
            pf[i] = pf[i - 1] + pf[i];
        }
        return pf;
    }

    public int[] solve(int A, int[][] B) {
        int[] res = new int[A];
        for (int[] ints : B) {
            res[ints[0] - 1] += ints[2];
            if (ints[1] != A) {
                res[ints[1]] -= ints[2];
            }
        }
        for (int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
