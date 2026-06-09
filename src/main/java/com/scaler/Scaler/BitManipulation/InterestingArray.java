package com.scaler.Scaler.BitManipulation;

public class InterestingArray {
    //    You have an array A with N elements. We have two types of operation available on this array :
//    We can split an element B into two elements, C and D, such that B = C + D.
//    We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
//    You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0 after several splits and/or merge?
    public String solve(int[] A) {
        int len = A.length, cnt = 0;
        // no of odd count element watch video to u
        for (int j : A) {
            // COUNT OF ODD NO
            if (j % 2 != 0) {
                cnt++;
            }
        }
        if (cnt % 2 == 0) {
            return "Yes";
        }
        return "No";
    }
//////////////////////////////////////////////////////////////////////////////////////////

    public String solve2(int[] A) {
        int ans = A[0];
        for (int i = 1; i < A.length; i++)
            ans = ans ^ A[i];

        if (ans % 2 == 0) return "Yes";
        return "No";
    }
}
