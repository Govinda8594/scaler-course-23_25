package com.scaler.Scaler.Strings;

public class RearrangeToGetMinimumPeriodOfString {

    public static int minimumPeriod(String s) {
        int[] map = new int[26];
        int len = s.length(), gcd = 0;
        for (int i = 0; i < len; i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < map.length; i++) {
            gcd = gcd(gcd, map[i]);
        }
        return len / gcd;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
