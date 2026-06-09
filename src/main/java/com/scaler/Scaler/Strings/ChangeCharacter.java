package com.scaler.Scaler.Strings;

import java.util.Arrays;

public class ChangeCharacter {
    //    You are given a string A of size N consisting of lowercase alphabets.
//    You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
//    Find the minimum number of distinct characters in the resulting string.
    public static void main(String[] args) {
        minimizeDistinctCharacter("abcabbccd", 3);
    }

    static int minimizeDistinctCharacter(String character, int B) {
        int size = character.length(), count = 0;
        int[] freq = new int[26];
        for (int i = 0; i < size; i++) {
            freq[character.charAt(i) - 97]++;
//            freq[character.charAt(i) - 'a']++;
//            freq[character.charAt(i)%97]++;
        }
        Arrays.sort(freq);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (B > 0) {
                    int temp = B;
                    B = B - freq[i];
                    freq[i] = freq[i] - temp;
                }
            }
            if (freq[i] > 0)
                count++;
        }
        return count == 0 ? 1 : count;
    }
}
