package com.scaler.Scaler.MathDSA.Modulo;

public class VeryLargeFastPower {
    static int fast_power(long A, long B, long mod) {
        long ans = 1;
        while (B > 0) {
            if ((B & 1) == 1) {
                ans = (ans * A) % mod;
            }
            A = (A % mod * A % mod) % mod;
            B = B >> 1;
        }
        return (int) (ans % mod);
    }

    //    Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
//
//            "^" means power,
//"%" means mod, and
//"!" means factorial.
    public int solve(int A, int B) {
        long fact = 1;
        long mod = 1000000007;
        for (long i = 2; i <= B; i++) {
            fact = (fact * i) % (mod - 1);
        }
        return fast_power(A, fact, mod);
    }
}
