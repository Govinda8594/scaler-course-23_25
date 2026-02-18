package com.scaler.Scaler.MathDSA.Modulo;

import java.util.HashMap;

//Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
//
//        Since the answer may be large, return the answer modulo (109 + 7).
//
//        Note: Ensure to handle integer overflow when performing the calculations.
public class PairSumDivisibleByModulo {
    public int solve(int[] A, int B) {
        //Step 1 Create the count array and store the frequency of A[i]%m in count array
        long[] count = new long[B];
        for (int k : A) {
            int rem = k % B;
            count[rem]++;
        }
        //Step 2 find the number of pairs and handle edge cases
        //Edge Case for rem =0
        long ans = 0;
        long x = count[0];
        ans += (x * (x - 1)) / 2;
        //Edge case for rem = B/2 only valid if B is even in odd case not valid
        if (B % 2 == 0) {
            long y = count[B / 2];
            ans += (y * (y - 1)) / 2;
        }
        //normal cases way 1
        int i = 1;
        int j = B - 1;
        while (i < j) {
            ans += count[i] * count[j];
            i++;
            j--;
        }

        //normal cases way 2
        for (int k = 1; k < (B + 1) / 2; k++) {
            ans += count[k] * count[B - k];
        }

        return (int) (ans % 1000000007);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public int solve2(int[] A, int B) {
        long cnt = 0, len = A.length;
        long mod = 1000000007;
        HashMap<Integer, Long> hm = new HashMap<>();
        for (int j : A) {
            Integer x = j % B;
            hm.put(x, hm.getOrDefault(x, 0L) + 1);
        }
        if (hm.containsKey(0)) {
            cnt = cnt + (hm.get(0) * (hm.get(0) - 1)) / 2;
        }
        int l = 1, r = B - 1;
        while (l < r) {
            if (hm.containsKey(l) && hm.containsKey(r)) {
                cnt = cnt + hm.get(l) * hm.get(r);
            }
            l++;
            r--;
        }
        if (l == r && hm.containsKey(l)) {
            cnt += (hm.get(l) * (hm.get(l) - 1)) / 2;
        }
        return (int) ((cnt + mod) % mod);
    }
}
