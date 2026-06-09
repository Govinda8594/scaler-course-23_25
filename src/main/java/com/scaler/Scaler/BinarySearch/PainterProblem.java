package com.scaler.Scaler.BinarySearch;

//Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
//        You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
//
//        Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
//        NOTE:
//        1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
//        2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
//
//        Return the ans % 10000003.
public class PainterProblem {
    public static boolean CheckPossible_MID(int[] C, long mid, long A, long n) {
// C --> array, mid --> units of time , A --> no of workers , n --> length of array
        long sum = 0; // sum --> for more understanding mins we are referrring
        int current_Worker = 1;
        for (int i = 0; i < n; i++) {
            sum = sum + C[i];
            if (sum > mid) {
                sum = C[i];
                current_Worker++; // if we exceeds the mid, there we are assigning the new worker (Hey you, come and start the work from here)
                if (current_Worker > A) {
//current_Worker should not exceed the given fixed workes (Boss said to finish this work within given (A) fixed workers)
                    return false; //Boss will terminate us
                }
            }
        }
        return true; // Boss will aprreciate us
    }

    public int paint(int A, int B, int[] C) {
//A ---> painters
//B ---> units of time;
        int mod = 10000003;
        long n = C.length;
// Finding search sapce (Search Space ---> l ,r)
        long l = Integer.MIN_VALUE; //Maxi element in the array
        long r = 0; //total sum of the array
        for (int j : C) {
            l = Math.max(l, j);
            r = r + j;
        }
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
// C --> array, mid --> units of time , A --> no of workers , n --> length of array
            if (CheckPossible_MID(C, mid, A, n)) {
//if that mid is possible check below that mid is possible
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((ans * B) % mod);
    }
// TC => O(N * log(r- l) ) for understanding --> o( N * log (ToatlSum(array)- max_element)
}
