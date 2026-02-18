package com.scaler.Scaler.Hashing;

import java.util.Arrays;

public class CheckTwoStringArePermutation {

    static boolean arePermutation2(char str1[], char str2[]) {
        // If both strings are of different length.
        // Removing this condition will make the
        // program fail for strings like "aaca" and
        // "aca"
        if (str1.length != str2.length) {
            return false;
        }
        // Create a count array and initialize all
        // values as 0
        int count[] = new int[NO_OF_CHARS];
        int i;
        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (i = 0; i < str1.length && i < str2.length; i++) {
            count[str1[i]]++;
            count[str2[i]]--;
        }
        // See if there is any non-zero value in
        // count array
        for (i = 0; i < NO_OF_CHARS; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    static int NO_OF_CHARS = 256;
    static boolean arePermutation(char str1[], char str2[]) {
        // Create 2 count arrays and initialize
        // all values as 0
        int count1[] = new int[NO_OF_CHARS];
        Arrays.fill(count1, 0);
        int count2[] = new int[NO_OF_CHARS];
        Arrays.fill(count2, 0);
        int i;
        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (i = 0; i < str1.length && i < str2.length;
             i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }
        // If both strings are of different length.
        // Removing this condition will make the program
        // fail for strings like "aaca" and "aca"
        if (str1.length != str2.length) {
            return false;
        }
        // Compare count arrays
        for (i = 0; i < NO_OF_CHARS; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    static boolean arePermutation(String str1, String str2) {
        // Get lengths of both strings
        int n1 = str1.length();
        int n2 = str2.length();
        // If length of both strings is not same,
        // then they cannot be Permutation
        if (n1 != n2) {
            return false;
        }
        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();
        // Sort both strings
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        // Compare sorted strings
        for (int i = 0; i < n1; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }
}
