package com.scaler.Scaler.Recursion;

public class PowerFunction {

    public int pow(int A, int B) {
        if (B == 0) {
            return 1;
        }
        return pow(A, B - 1) * A;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    public int pow2(int A, int B) {
        if (B == 0) {
            return 1;
        }
        if (B % 2 == 0) {
            return pow2(A, B / 2) * pow2(A, B / 2);
        }
        return pow2(A, B / 2) * pow2(A, B / 2) * A;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int pow3(int A, int B) {
        if (B == 0) {
            return 1;
        }
        int pow = pow3(A, B / 2);
        if (B % 2 == 0) {
            return pow * pow;
        }
        return pow * pow * A;
    }
}
