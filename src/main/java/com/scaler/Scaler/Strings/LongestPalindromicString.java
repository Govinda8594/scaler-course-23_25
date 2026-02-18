package com.scaler.Scaler.Strings;

public class LongestPalindromicString {
    public static void main(String[] args) {
        // O(N3)
//        int maxlen = longestStringlen("abacab");
//        String ans = longestPalindromicString("abacab");
        // O(N2)
//        int ans1 = longestPalindromicStringwith2Pointer("abacabb");
//        String ans = longestPalindrome("abacab");


    }

    public static String longestPalindrome(String A) {
        if (A == null) return null;
        int maxlen = Integer.MIN_VALUE;
        String longest = A.substring(0, 1);
        for (int i = 0; i < A.length() - 1; i++) {
            // for odd length String
            String palindrome = intermediatePalindrome(A, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
                maxlen = longest.length();
            }
            // even length string
            palindrome = intermediatePalindrome(A, i, i + 1);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
                maxlen = longest.length();
            }
        }
        return longest;
    }

    static public String intermediatePalindrome(String s, int left, int right) {
        if (left > right) return null;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    static int longestPalindromicStringwith2Pointer(String A) {
        int len = A.length(), maxlen = Integer.MIN_VALUE;
        String ans = "";
        // for odd length String
        for (int i = 0; i < len; i++) {
            int ptr1, ptr2;
            ptr1 = i;
            ptr2 = i;
            maxlen = Math.max(maxlen, expandAroundPointer(A, ptr1, ptr2, len, ans));
        }
        // even length string
        for (int i = 0; i < len - 1; i++) {
            int ptr1, ptr2;
            ptr1 = i;
            ptr2 = i + 1;
            maxlen = Math.max(maxlen, expandAroundPointer(A, ptr1, ptr2, len, ans));
        }
        return maxlen;
    }


    // O(N3) algorithm
    static String longestPalindromicString(String A) {
        int len = A.length(), maxlen = Integer.MIN_VALUE;
        String ans = "";
        // create subArray String
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (checkpalindromicString(A, i, j)) {
                    if (j - i + 1 > maxlen) {
                        maxlen = j - i + 1;
                        ans = A.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }

    static int longestStringlen(String A) {
        int len = A.length(), maxlen = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (checkpalindromicString(A, i, j)) {
                    maxlen = Math.max(maxlen, j - i + 1);
                }
            }
        }
        return maxlen;
    }

    static boolean checkpalindromicString(String A, int i, int j) {
        while (i < j) {
            if (A.charAt(i) != A.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static int expandAroundPointer(String A, int ptr1, int ptr2, int len, String ans) {
        while (ptr1 >= 0 && ptr2 < len && A.charAt(ptr1) == A.charAt(ptr2)) {
            ptr1--;
            ptr2++;
        }

        if (A.substring(ptr1 + 1, ptr2).length() > ans.length()) {
            ans = A.substring(ptr1 + 1, ptr2);
        }
        return ptr2 - ptr1 - 1;
    }
}
