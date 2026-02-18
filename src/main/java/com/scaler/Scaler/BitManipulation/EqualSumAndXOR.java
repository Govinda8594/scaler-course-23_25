package com.scaler.Scaler.BitManipulation;

//Given an integer A.
//        Two numbers, X and Y, are defined as follows:
//        X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
//        Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
//        Find and return the XOR of X and Y.
//        NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.
//        NOTE 2: Your code will be run against a maximum of 100000 Test Cases.
public class EqualSumAndXOR {
    public static void main(String[] args) {
        sumAndXor(5);
    }

    static int sumAndXor(int A) {
        int bit = 0, x = 0;
        // x is equal to the summation of unset bits in A
        while (A != 0) {
            if (A % 2 == 0) {
                x = x | (1 << bit);
            }
            A /= 2;
            bit++;
        }
        // y equals the power of 2 just greater than A
        int y = (1 << bit);
        return x ^ y;
    }

    static int unset_bits(int A) {
        int len = 0;
        while (A >= (1 << len)) {
            len++;
        }
        int max = 1 << (len);
        int min = A;
        for (int i = 0; i < len; i++) { // toggle all bits
            min = min ^ (1 << i);
        }
        return min + max;
    }
}