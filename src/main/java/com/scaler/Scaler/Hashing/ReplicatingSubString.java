package com.scaler.Scaler.Hashing;

import java.util.HashMap;
//Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.
//        Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
//        If it is possible, return 1, else return -1.
public class ReplicatingSubString {
    public int replicatingSubString(int A, String B) {
        int len = B.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : B.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int val : map.values()) {
            if (val % A != 0) {
                return -1;
            }
        }
        return 1;
    }

    public int solve(int A, String B) {
        int[] freq = new int[26];
        for (int i = 0; i < B.length(); i++) {
            freq[B.charAt(i) - 'a'] += 1;
        }
        for (int val : freq) {
            if (val % A != 0) {
                return -1;
            }
        }
        return 1;
    }
}
