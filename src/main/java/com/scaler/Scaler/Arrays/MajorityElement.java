package com.scaler.Scaler.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
//        majorityElement()
    }

    public static int majorityElement(final int[] A) {
        int me = A[0];
        int feq = 1;
        int len = A.length;
        for (int i = 1; i < len; i++) {
            if (feq == 0) {
                me = A[i];
                feq = 1;
            } else if (me == A[i]) {
                feq++;
            } else {
                feq--;
            }
        }

        int count = 0;
        for (int j : A) {
            if (me == j)
                count++;
        }
        int result = 0;
        if (count > (int) Math.floor((double) len / 2)) {
            result = me;
        }
        return result;
    }

}
