package com.scaler.Scaler.MathDSA.GeneralProblem;

public class JosephusProblem {
    public static void main(String[] args) {
//        int survive = josephus1(3);
    }

    public static int josephus1(int A) {
        int pow2 = 1;
        // get nearest power of two like half of person will be killed
        while (pow2 <= A) {
            pow2 *= 2;
        }
        // minus the power of two with jump value 2*no of A and plus 1 to get the answer.
        // adding 1 for 1- bazed indexing ,last person will be 2 * A - power
        return 1 + 2 * A - pow2;
    }
}
