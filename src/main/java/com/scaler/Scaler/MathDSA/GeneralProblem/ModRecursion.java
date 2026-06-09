package com.scaler.Scaler.MathDSA.GeneralProblem;

public class ModRecursion {
    public static void main(String[] args) {
        int ans = fun(2, 10);
    }

    private static int fun(int x, int n) {
        if (n == 0) return 1;
        else if (n % 2 == 0)
            return fun(x * x, n / 2);
        else return x * fun(x * x, (n - 1) / 2);
    }
}
