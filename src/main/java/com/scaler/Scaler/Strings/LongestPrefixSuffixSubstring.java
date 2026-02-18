package com.scaler.Scaler.Strings;

public class LongestPrefixSuffixSubstring {
    static int[] lps(String A) {
        int len = A.length();
        int[] lps = new int[len];
        for (int i = 1; i < len; i++) {
            int x = lps[i - 1];
            while (A.charAt(i) != A.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }
        return lps;
    }
}
