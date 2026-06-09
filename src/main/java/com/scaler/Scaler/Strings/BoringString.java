package com.scaler.Scaler.Strings;

import java.util.Arrays;

//You are given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.
//
//        A boring substring has the following properties:
//
//        Its length is 2.
//        Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
//        Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.
public class BoringString {

    //    INTUITION
//    The main intuition behind this problem statement is to partition the characters between two groups.
//    How to partition : Based on ascii values I can divide the whole string into two parts with odd and even basis.
//    If I want to merged the partitioned strings , I need to maximized the distance between the chars.
//
//    How to maximize the diff : Max Val - Min Val
//    I need to check for both evenMax - oddMin as well as oddMax - evenMin
//if any result not equal to 1 return 1;
    public int solve2(String A) {
        int evenMax = Integer.MIN_VALUE;
        int evenMin = Integer.MAX_VALUE;
        int oddMax = Integer.MIN_VALUE;
        int oddMin = Integer.MAX_VALUE;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            int val = (int) (A.charAt(i) - 'a');
            if (val % 2 == 0) {
                evenMax = Math.max(evenMax, val);
                evenMin = Math.min(evenMin, val);
            } else {
                oddMax = Math.max(oddMax, val);
                oddMin = Math.min(oddMin, val);
            }
        }
        if (Math.abs(evenMax - oddMin) != 1 || Math.abs(oddMax - evenMin) != 1) {
            return 1;
        }
        return 0;
    }

    //////////////////////////////////////////////////////////////////////////////////////

    public int solve(String A) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        // odd and even stores odd and even characters respective
        for (int i = 0; i < A.length(); ++i) {
            char c = A.charAt(i);
            if (c % 2 == 0) {
                odd.append(c);
            } else {
                even.append(c);
            }
        }
        char[] ar = odd.toString().toCharArray();
        Arrays.sort(ar);
        odd = new StringBuilder(String.valueOf(ar));
        ar = even.toString().toCharArray();
        Arrays.sort(ar);
        even = new StringBuilder(String.valueOf(ar));
        // check if either (odd + even) or (even + odd) has no boring substrings
        if (check(odd + even.toString())) {
            return 1;
        } else if (check(even.toString() + odd)) {
            return 1;
        }
        return 0;
    }

    public boolean check(String s) {
        boolean ok = true;
        for (int i = 0; i + 1 < s.length(); ++i) {
            ok &= (Math.abs(s.charAt(i) - s.charAt(i + 1)) != 1);
        }
        return ok;
    }
}
