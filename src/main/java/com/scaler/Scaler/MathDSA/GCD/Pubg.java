package com.scaler.Scaler.MathDSA.GCD;

public class Pubg {
    public static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }

    //    There are N players, each with strength A[i]. when player i attack player j, player j strength reduces to max(0, A[j]-A[i]). When a player's strength reaches zero, it loses the game, and the game continues in the same manner among other players until only 1 survivor remains.
//
//    Can you tell the minimum health last surviving person can have?
    public int pubg(int[] A) {
        int ans = A[0], len = A.length;
        for (int i = 1; i < len; i++) {
            ans = Math.min(ans, gcd(ans, A[i]));
        }
        return ans;
    }
}
