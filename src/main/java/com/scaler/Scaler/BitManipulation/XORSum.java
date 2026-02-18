package com.scaler.Scaler.BitManipulation;

public class XORSum {
    //    Given two integers A and B. Find the minimum value (A ⊕ X) + (B ⊕ X) that can be achieved for any X.
//
//    where P ⊕ Q is the bitwise XOR operation of the two numbers P and Q.
//
//            Note: Bitwise XOR operator will return 1, if both bits are different. If bits are same, it will return 0.
    public int solve(int A, int B) {
        return (A ^ (A & B)) + (B ^ (A & B));
    }
//   if ith bit in both the no is 1 then in X ith bit should be 1
//   if ith bit in both the no is 0 then in X  ith bt should be 0
//   if ith bit in the no are differet then in X is should either 0;
//  1001 = A
//  1010 = B
//  1000 = X => A & B
}
