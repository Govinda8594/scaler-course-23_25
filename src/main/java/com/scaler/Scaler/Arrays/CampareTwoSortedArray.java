package com.scaler.Scaler.Arrays;

public class CampareTwoSortedArray {

    //    Given an array A of length N. You have to answer Q queries.//
//    Each query will contain four integers l1, r1, l2, and r2.
//    If sorted segment from [l1, r1] is the same as the sorted segment
//    from [l2 r2], then the answer is 1 else 0.
//    NOTE The queries are 0-indexed.
    public int[] solve(int[] A, int[][] B) {
        int[] ans = new int[B.length];
        int[] pref = new int[A.length];
        pref[0] = A[0] * A[0];
        for (int i = 1; i < A.length; i++) {
            pref[i] = pref[i - 1] + A[i] * A[i];//hashing done here by just manipulate value and then insert in pref array
        }
        // we use sum and check for query if sum is equal on both side then return 1;
        //but only sum will not work so we have to hash the value for ex
        //if input like 1 3 4  and 4 4 both has same sum but elements are not same hence require to hash.
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < B.length; i++) {
            int l1 = B[i][0];
            int r1 = B[i][1];
            int l2 = B[i][2];
            int r2 = B[i][3];
            if (l1 == 0) {
                sum1 = pref[r1];
            } else {
                sum1 = pref[r1] - pref[l1 - 1];
            }
            if (l2 != 0) {
                sum2 = pref[r2] - pref[l2 - 1];
            } else {
                sum2 = pref[r2];
            }
            if (sum1 == sum2) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }
}
