package com.scaler.Scaler.Arrays;

public class JosephusProbelm {
    //    There are A people standing in a circle.
//    Person 1 kills their immediate clockwise neighbour and pass the knife to the next person standing in circle.
//    This process continues till there is only 1 person remaining. Find the last person standing in the circle.
    public int solve(int A) {
        int pow2 = 1;
        // make number to nearest power of 2
        while (pow2 <= A) {
            pow2 *= 2;
        }
        pow2 = pow2 / 2; // it might happen pow will exceed A so to get back divide by 2
        int kill = A - pow2; // // no of kill
        return 1 + 2 * kill; // 2 => no of jumps * kill
    }
}
