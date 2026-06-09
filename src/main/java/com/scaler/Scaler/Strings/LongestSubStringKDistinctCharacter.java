package com.scaler.Scaler.Strings;

import java.util.HashSet;

public class LongestSubStringKDistinctCharacter {
    public static void main(String[] args) {
        kdistinctCharacter("acbaab", 2);
    }

    public static int kdistinctCharacter(String A, int B) {
        int len = A.length(), maxlen = Integer.MIN_VALUE;
        String ans = "";
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
//                for (int k = i; k <= j ; k++) {
                String s = A.substring(i, j + 1);
                HashSet<Character> set = new HashSet<>();
                for (char c : s.toCharArray()) {
                    set.add(c);
                }
                int stringlen = j - i + 1;
                if (set.size() == B && stringlen > maxlen) {
                    maxlen = stringlen;
                    ans = A.substring(i, j + 1);
//                }
                }
            }
        }
        return maxlen;
    }
}
