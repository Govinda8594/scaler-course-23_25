package com.scaler.Scaler.Recursion;

public class Palindrome {

    public static void main(String[] args) {
        int ans = checkpalindromeRecursion("naman");
    }

    public static int checkpalindromeRecursion(String A) {
        return ispal(A.toCharArray(), 0, A.length() - 1);
    }

    static int ispal(char[] array, int start, int end) {
        if (start > end) {
            return 1;
        }
        if (array[start] == array[end] && ispal(array, ++start, --end) == 1) {
            return 1;
        }
        return 0;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve(String A) {
        if (A.charAt(0) != A.charAt(A.length() - 1)) {
            return 0;
        }
        if (A.length() == 1 || A.length() == 2) {
            return 1;
        }
        return solve(A.substring(1, A.length() - 1));
    }
}
