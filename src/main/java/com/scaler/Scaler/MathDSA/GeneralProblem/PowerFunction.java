package com.scaler.Scaler.MathDSA.GeneralProblem;

public class PowerFunction {
    public static void main(String[] args) {
        new PowerFunction().powerFuctionBrute(2, 20);
    }

    public int power(final int A, final int B) {
        int c = 1;

        for (int i = 0; i < B; i++) {
            c = c * A;
        }

        return c;

    }

    int powerFuctionBrute(int num, int power) {
//        power = power
        int m = power; // for -ve power
        int ans = 1;
        while (power > 0) {
            if (power % 2 == 1) {
                ans = ans * num;
                power = power - 1;
            } else {
                power = power / 2;
                num = num * num;
            }
            if (m < 0) //for -ve power
                ans = 1 / ans;
        }
        return ans;
    }
}
