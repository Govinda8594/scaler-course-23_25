package com.scaler.Scaler.BitManipulation;

public class bitOperation {
    public static void main(String[] args) {

    }

    public static int usetithbit(int A, int B) {
//            if(
//                // (A | (1<<B)) == A
//                // (A & (1 << B)) == (1 << B)
//                    (A ^ (1 << B)) < A
//            )
//                A = A ^ (1<<B);
//            return A;

//        return A&~(1<<B);

        int res = A | (1 << B);
        if (res == A) return (res & ~(1 << B));
        return A;
    }
//    You are given two integers A and B.
//    Set the A-th bit and B-th bit in 0, and return output in decimal Number System.

    public static int setithbit(int A, int B) {
        return (1 << A) | (1 << B);
    }

    public long setBbitsfromrigth(long A, int B) {
        for (int i = 0; i < B; i++) {
            if ((A & (1L << i)) == (1L << i)) {
                A = A ^ (1L << i);
            }
        }
        return A;
    }

    //    You are given two integers A and B.
//    If B-th bit in A is set, make it unset
//    If B-th bit in A is unset, make it set
//    Return the updated A value
    public int toggleIthBit(int A, int B) {
        return (A ^ (1 << B));
    }

//    Alex and Sam are good friends. Alex is doing a lot of programming these days. He has set a target score of A for himself.
//    Initially, Alex's score was zero. Alex can double his score by doing a question, or Alex can seek help from Sam for doing questions that will contribute 1 to Alex's score. Alex wants his score to be precisely A. Also, he does not want to take much help from Sam.
//
//    Find and return the minimum number of times Alex needs to take help from Sam to achieve a score of A.

    public int helpfromsam(int A) {
        int count = 0;
        for (int i = 0; i < 31; i++) {
            if ((A & (1 << i)) != 0) count++;
        }
        return count;
    }

    public int helpfromsam2(int A) {
        int count = 0;
        while (A > 0) {
            if ((A & 1) == 1) {
                count++;
            }
            A = A >> 1;
        }
        return count;
    }

    //    Alex has a cat named Boomer. He decides to put his cat to the test for eternity.
//
//    He starts on day 1 with one stash of food unit, every next day, the stash doubles.
//
//    If Boomer is well behaved during a particular day, only then she receives food worth equal to the stash produced on that day.
//
//    Boomer receives a net worth of A units of food. What is the number of days she received the stash?
    public int findgoodday(int A) {
        int count = 0;
        for (int i = 0; i < 31; i++) {
            if ((A & (1 << i)) != 0) count++;
        }
        return count;
    }

    public int findgoodday2(int A) {
        int count = 0;
        while (A > 0) {
            if ((A & 1) == 1) {
                count++;
            }
            A = A >> 1;
        }
        return count;
    }
}
