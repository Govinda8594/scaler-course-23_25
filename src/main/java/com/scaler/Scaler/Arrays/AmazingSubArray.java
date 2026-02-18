package com.scaler.Scaler.Arrays;

public class AmazingSubArray {

//    You are given a string S, and you have to find all the amazing substrings of S.
//
//    An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
//
//    Input
//
//    Only argument given is string S.
//    Output
//
//    Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
//    Constraints
//
//1 <= length(S) <= 1e6
//    S can have special characters

    public int solve(String A) {
        int ans = 0, substringlen;
        for (int i = 0; i < A.length(); i++) {
            String string = Character.toString(A.charAt(i));
            if (string.equalsIgnoreCase("a") ||
                    string.equalsIgnoreCase("e") ||
                    string.equalsIgnoreCase("i") ||
                    string.equalsIgnoreCase("o") ||
                    string.equalsIgnoreCase("u")
            ) {
                substringlen = A.length() - i;
                ans += substringlen;
                ans = ans % 10003;

            }
        }
        return ans;
    }
}
