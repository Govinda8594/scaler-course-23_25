package com.scaler.Scaler.MathDSA.GeneralProblem;

public class LCMHCF {
    public static void main(String[] args) {
        LCM();
        HCF();
    }

    private static void LCM() {
        int a = 4;
        int b = 8;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        for (int i = 1; i <= max; i++) {
            int ans = i * max;

            if (ans % min == 0) {
                System.out.print(ans);
                break;
            }

        }
        int A = a;
        int B = b;
        int lcm = A > B ? A : B;
        while (true) {
            if (lcm % A == 0 && lcm % B == 0) {
                System.out.println(lcm);
                break;
            }
            ++lcm;
        }
    }

    static void HCF() {
        int A = 54;
        int B = 54;
        int remainder = 0;
        if (A < B) {
            remainder = B % A;
            if (remainder == 0)
                System.out.print(A);
        } else {
            remainder = A % B;
            if (remainder == 0)
                System.out.print(B);
        }
    }
}
