package com.scaler.Scaler.Sorting;

import java.util.Arrays;

public class SortByColor {
    public static void main(String[] args) {

    }

    static int[] withoutsortfunction(int[] A) {
        int len = A.length;
        int[] freq = new int[3];
        // by storing the frequency of 0,1,2 ==> 0 -> red,1->whilte, 2->blue
        for (int j : A) {
            freq[j]++;
        }
        int[] ans = new int[len];
        int count = 0;
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] != 0) {
                ans[count] = i;
                count++;
                freq[i]--;
            }
        }
        return ans;
    }

    static int[] getSortbyColor(int[] A) {
        int len = A.length;
        Arrays.sort(A);
        return A;
    }
}
