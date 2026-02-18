package com.scaler.Scaler.BitManipulation;

public class Checkbit {
    public int solve(int A, int B) {
        return checkbitwithOR(A, B);
    }
    private int checkbitwithOR(int A, int B) {
        //  with or operator
        // if A | (1<<i) == A then the bit is set
        // otherwise A | (1<<i) == A + (1<<i) then the bit is unset
        if((A|(1<<B)) == A) return 1;
        return 0;
    }
    private int checkbitwithAND(int A, int B) {
        //  with AND operator
        // if A & (1<<i) == 1 => then the bit is set
        // otherwise A & (1<<i) == 0 ==> then the bit is unset
        if((A&(1<<B)) > 0) return 1;
        return 0;
    }
    private int checkbitwithXOR(int A, int B) {
        //  with XOR operator
        // if A ^ (1<<i) > A => A + (1<<i) then the bit is unset
        // otherwise A ^ (1<<i) <A == > A - (1<<i) then the bit is set
        if((A^(1<<B)) < A) return 1;
        return 0;
    }
}
