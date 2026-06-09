package com.scaler.Scaler.Arrays;

public class MajorityElement3 {
    public int repeatedNumber(int[] A) {
        int len = A.length;
        if (len == 1) return A[0];

        int me1 = 0, fe1 = 0, me2 = 0, fe2 = 0;

        for (int num : A) {
            if (me1 == num) {
                fe1++;
            } else if (me2 == num) {
                fe2++;
            } else if (fe1 == 0) {
                me1 = num;
                fe1 = 1;
            } else if (fe2 == 0) {
                me2 = num;
                fe2 = 1;
            } else {
                fe1--;
                fe2--;
            }
        }

        int f1 = 0, f2 = 0;

        for (int num : A) {
            if (me1 == num) f1++;
            if (me2 == num) f2++;
        }

        return f1 > len / 3 ? me1 : f2 > len / 3 ? me2 : -1;

    }
}
