package com.scaler.Scaler.DynamicProgramming;

//In Danceland, one person can party either alone or can pair up with another person.
//        Can you find in how many ways they can party if there are A people in Danceland?
//        Note: Return your answer modulo 10003, as the answer can be large.
//        Problem Constraints
//        1 <= A <= 105
//        Input Format
//        Given only argument A of type Integer, number of people in Danceland.
//        Output Format
//        Return an integer denoting the number of ways people of Danceland can party.

public class Let_Party {
    /////////////////////Without Using DP+ tabulation/////////////////////////////////////////////////

    public int solve2(int A) {
        int a = 1;
        int b = 1;
        for (int i = 2; i <= A; i++) {
            // can party (A-1) way i.e alone + (A - 1) can pair ie mutiply * (A-2) no of people
            int tempWays = (b + a * (i - 1)) % 10003;
            a = b;
            b = tempWays;
        }
        return b;
    }
    //////////////////////////////////////////////////////////////////////////

    public int solve4(int A) {
        // return Pairs_Rec(A);
        return Pairs_Memo(A, new int[A + 1]);
        // return Pairs_Tab(A,new int[A+1]);
    }

    public int Pairs_Rec(int A) {
        if (A <= 2) {
            return A;
        }
        // can party (A-1) way i.e alone + (A - 1) can pair ie mutiply * (A-2) no of people
        return (Pairs_Rec(A - 1) + (A - 1) * Pairs_Rec(A - 2)) % 10003;
    }

    public int Pairs_Memo(int A, int[] dp) {
        if (A <= 2) {
            return A;
        }
        if (dp[A] == 0) {
            dp[A] = Pairs_Memo(A - 1, dp) + (A - 1) * Pairs_Memo(A - 2, dp);
        }
        return dp[A] % 10003;
    }

    public int Pairs_Tab(int A, int[] dp) {
        if (A == 1) {
            return A;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= A; i++) {
            dp[i] = dp[i - 1] + ((i - 1) * dp[i - 2]);
            dp[i] %= 10003;
        }
        return dp[A] % 10003;
    }
}
