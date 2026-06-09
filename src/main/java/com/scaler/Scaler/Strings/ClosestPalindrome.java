package com.scaler.Scaler.Strings;
//Groot has a profound love for palindrome which is why he keeps fooling around with strings.
//        A palindrome string is one that reads the same backward as well as forward.
//
//        Given a string A of size N consisting of lowercase alphabets,
//        he wants to know if it is possible to make the given string a palindrome
//        by changing exactly one of its character.
public class ClosestPalindrome {
    public String solve(String A) {
        int p1 = 0;
        int p2 = A.length() - 1;
        int count = 0;
        while (p1 <= p2) {
            if (A.charAt(p1) != A.charAt(p2)) {
                count++;
            }
            p1++;
            p2--;
        }
        if (A.length() % 2 == 1 && count == 0) {
            return "YES";
        }
        return count == 1 ? "YES" : "NO";
    }
}
