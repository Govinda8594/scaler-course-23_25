package com.scaler.Scaler.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class CountSubStringWhichArePermuationOfGivenString {

    public static void main(String[] args) {
        String A = "aba";
        String B = "ababbaab";
//        countSubStringWhichArePermuationOfGivenString("daba", "aadbaba");
        countSubStringWhichArePermuationOfGivenString(A, B);
    }

    public static void countSubStringWhichArePermuationOfGivenString(String A, String B) {
        int count = 0;
        HashMap<Character, Integer> freqA = new HashMap<>();
        HashMap<Character, Integer> freqB = new HashMap<>();
        int len = A.length(), blen = B.length();
        for (int i = 0; i < len; i++) {
            char c = A.charAt(i);
            freqA.put(c, freqA.getOrDefault(c, 0) + 1);
        }
        for (int j = 0; j < len; j++) {
            char c = B.charAt(j);
            freqB.put(c, freqB.getOrDefault(c, 0) + 1);
        }
        if (freqA.equals(freqB)) {
            count++;
        }
        int i = 1, j = len;
        while (j < blen) {
            char prevChar = B.charAt(i - 1);
            if (freqB.containsKey(prevChar)) {
                freqB.put(prevChar, freqB.get(prevChar) - 1);
                if (freqB.get(prevChar) == 0) {
                    freqB.remove(prevChar);
                }
            }
            char c = B.charAt(j);
            freqB.put(c, freqB.getOrDefault(c, 0) + 1);
            if (freqA.equals(freqB)) {
                count++;
            }
            i++;
            j++;
        }
        System.out.println(count);
    }

    public static void countSubStringWhichArePermuationOfGivenString2(String A, String B) {
        int count = 0;
        int[] freqA = new int[26];
        for (int i = 0; i < A.length(); i++) {
            freqA[A.charAt(i) - 'a']++;
        }
        for (int i = 0; i < B.length(); i++) {
            int[] freqB = new int[26];
            for (int j = i; j < B.length(); j++) {
                freqB[B.charAt(j) - 'a']++;
                if (Arrays.equals(freqA, freqB)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
