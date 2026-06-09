package com.scaler.Scaler.MathDSA.GeneralProblem;

public class SpecialIndex {
    public static void main(String[] args) {
        int ans = countspecialIndex(new int[]{2, 1, 6, 4});
    }

    public static int countspecialIndex(int[] A) {
        int len = A.length;
        int[] pfEven = new int[len];
        int[] pfOdd = new int[len];
        int count = 0;
        pfEven[0] = A[0];
        pfOdd[0] = 0;
        for (int i = 1; i < len; i++) {
            if (i % 2 == 0) {
                pfEven[i] = pfEven[i - 1] + A[i];
                pfOdd[i] = pfOdd[i - 1];
            } else {
                pfEven[i] = pfEven[i - 1];
                pfOdd[i] = pfOdd[i - 1] + A[i];
            }
        }
        for (int i = 0; i < len; i++) {
            int sumeven = 0, sumodd = 0;
            // SUMEven[0 n] = originalsumEven[0...i - 1] + originalsumOddIdx[i + 1...n - 1]
            // SUMOdd[0 n] = originalsumOdd[0...i - 1] + originalsumEvenIdx[i + 1...n - 1]
            // odd index sum from original array,removing i = 0 from pfodd makeing evensum
            sumeven = pfOdd[len - 1] - pfOdd[i]; // when i = 0, then sumeven last pfsumodd[i...n-1]
            // even index sum from original array,removing i =0 from pfeven making oddsum
            sumodd = pfEven[len - 1] - pfEven[i];  //when i = 0, then sumodd last pfsumeven[i...n-1]
            if (i != 0) {
                sumeven += pfEven[i - 1];
                sumodd += pfOdd[i - 1];
            }
            if (sumeven == sumodd)
                count++;
        }
        return count;
    }

}
