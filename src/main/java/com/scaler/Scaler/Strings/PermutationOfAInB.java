package com.scaler.Scaler.Strings;

public class PermutationOfAInB {
    public int solve(String A, String B) {
        int[] count_A = new int[26];
        int[] count_B = new int[26];
        int n = A.length();
        int m = B.length();
        for (int i = 0; i < n; i++) {
            count_A[A.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            count_B[B.charAt(i) - 'a']++;
        }
        int ans = 0;
        if (check(count_A, count_B)) {
            ans++;
        }
        // using sliding window technique
        int l = 0;
        int r = n;
        while (r < m) {
            count_B[B.charAt(l) - 'a']--;
            count_B[B.charAt(r) - 'a']++;
            if (check(count_A, count_B)) {
                ans++;
            }
            l++;
            r++;
        }
        return ans;
    }

    public boolean check(int[] A, int[] B) {
        for (int i = 0; i < 26; i++) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;
    }
}
