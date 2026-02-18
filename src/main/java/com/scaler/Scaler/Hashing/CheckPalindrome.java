package com.scaler.Scaler.Hashing;

import java.util.Arrays;
import java.util.HashMap;

//Given a string A consisting of lowercase characters.
//        Check if characters of the given string can be rearranged to form a palindrome.
//        Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
public class CheckPalindrome {
    public int solve(String A) {
        int[] a = new int[26];
        int sum = 0;
        Arrays.fill(a, 0);
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            int index = c - 'a';
            if (a[index] == 0) {
                a[index]++;
            } else {
                a[index]--;
            }
        }
        for (int j : a) {
            sum = sum + j;
        }
        if (sum == 0 || sum == 1) {
            return 1;
        }
        return 0;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve1(String A) {
        int n = A.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (map.containsKey(ch)) {
                int temp = map.get(ch);
                temp++;
                map.put(ch, temp);
            } else {
                map.put(ch, 1);
            }
        }
        int odd = 0;
        for (Character c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                odd++;
            }
        }
        if (odd > 1) {
            return 0;
        }
        return 1;
    }
}
