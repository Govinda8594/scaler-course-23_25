package com.scaler.Scaler.BitManipulation;

//We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
//        For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.
//        You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.
public class DifferentBitSumPair {

    public static void main(String[] args) {
        cntBits(new int[]{2, 3});
    }

    public static int cntBits(int[] A) {
        long ans = 0;
        int n = A.length, Mod = 1000 * 1000 * 1000 + 7;
        // traverse over all bits
        for (int i = 0; i < 31; i++) {
            for (int value : A) {
                for (int j : A) {
                    int num = value ^ j;
                    if ((num >> i & 1) == 1)
                        ans++;
                }
            }
        }
        return (int) ans % Mod;
    }

    ///////////////////////////////////////////based on contrainst//////////////////////////////////////////////////
    public int cntBits2(int[] A) {
        int mod = 1000000007;
        int len = A.length;
        long ans = 0;

        // traverse over all bits
        for (int i = 0; i < 32; i++) {
            long setbits = 0;
            // count number of elements with i-th bit set
            for (int k : A) {
                if ((k & (1 << i)) > 0) {
                    setbits++;
                }
            }
            long pair = setbits * (len - setbits); // count of set bit ans unset bit
            ans = (ans + pair) % mod;
        }
        // ans multiply by 2 because i and j pairs
        ans = (ans * 2) % mod;
        return (int) ans;

    }

    ////////////////////////////based on contrainst////////////////////////////////////
    public int cntBits4(int[] A) {
        int mod = 1000000007;
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            long setbits = 0;
            for (int k : A) {
                if ((k & (1 << i)) > 0) {
                    setbits++;
                }
            }
            ans += (setbits * (A.length - setbits)) % mod;   // 1s count and 0s count
            ans %= mod;
        }
        return (int) (ans * 2) % mod;
    }
}
