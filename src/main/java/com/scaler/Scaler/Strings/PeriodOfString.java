package com.scaler.Scaler.Strings;

import java.util.ArrayList;

//You are given a string A of length N consisting of lowercase alphabets. Find the period of the string.
//        Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.
public class PeriodOfString {

    public int solve(String A) {
        ArrayList<Integer> Z = getZarr(A); // Z - Algorithm
        int n = A.length();
        for (int i = 1; i < n; i++) {
            if (i + Z.get(i) == n) {
                return i;
            }
        }
        return n;
    }

    public ArrayList<Integer> getZarr(String str) {
        int n = str.length();
        // Z array
        ArrayList<Integer> Z = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            Z.add(0);
        }
        int L, R, k;
        // [L, R] make a window which matches with prefix of str
        L = R = 0;
        for (int i = 1; i < n; ++i) {
            // if i > R nothing matches so we will calculate Z[i] using naive way
            if (i > R) {
                L = R = i;
                // R - L = 0 in starting, so it will start checking from 0'th index
                while (R < n && str.charAt(R - L) == str.charAt(R)) {
                    R++;
                }
                Z.set(i, R - L);
                R--;
            } else {
                // k = i - L so k corresponds to number which matches in [L,R] interval
                k = i - L;
                // if Z[k] is less than remaining interval then Z[i] will be equal to Z[k].
                if (Z.get(k) < R - i + 1) {
                    Z.set(i, Z.get(k));
                } else {
                    // else start from R and check manually
                    L = i;
                    while (R < n && str.charAt(R - L) == str.charAt(R)) {
                        R++;
                    }
                    Z.set(i, R - L);
                    R--;
                }
            }
        }
        return Z;
    }

    /////////////////////////////////////////////////////////////////////////////
    public int solve4(String A) {
        int n = A.length();
        int[] LPS = new int[n];
        LPS[0] = 0;
        for (int i = 1; i < n; i++) {
            int x = LPS[i - 1];
            while (A.charAt(i) != A.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = LPS[x - 1];
            }
            LPS[i] = x + 1;
        }
        int k = n - LPS[n - 1];
        return k;
    }
    ///////////////////////////////////////////////////////////////////////////////

    public int periodOfString(String A) {
        int LPS[] = computeLPS(A);
        int n = LPS.length;
        int count = 0;
        int startIndex = n - LPS[n - 1]; // period od string
        if (startIndex < 0) {
            return 0;
        }

        // verify the current is actually the minimum period of string
        for (int i = startIndex; i < n - 1; i++) {
            if (LPS[i + 1] - LPS[i] != 1) {
                return 0;
            }
        }
        return startIndex;
    }

    int[] computeLPS(String txt) {
        int n = txt.length();
        int[] LPS = new int[n];
        for (int i = 1; i < n; i++) {
            int x = LPS[i - 1];
            while (txt.charAt(i) != txt.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = LPS[x - 1];
            }
            LPS[i] = x + 1;
        }
        return LPS;
    }
    ///////////////////////////////////////////////////////////////////////////////////

    public int solve2(String A) {
        int k = 1;
        boolean flag = true;
        for (int i = 0; i < A.length(); i++) {
            flag = true;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != A.charAt(j % k)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                break;
            }
            k++;
        }
        if (k != 0) {
            return k;
        }
        return A.length();
    }
    ////////////////////////////////////////////////////////////////////////////////////

    //    for every A(i%k) == A(i) we can say that A(i+k) == A(i) == A(i-k). Iterate through the string to
//    check this. Where any of the above conditions fail, update k = i+1 (since i is 0 based).
    public int solve3(String A) {
        int n = A.length(), k = 1, i = 0;
        while (i < n) {
            if (A.charAt(i % k) != A.charAt(i)) {
                k = i + 1;
            } else if (i + k < n && A.charAt(i) != A.charAt(i + k)) {
                k = i + 1;
            } else if (i - k > 0 && A.charAt(i) != A.charAt(i - k)) {
                k = i + 1;
            }
            i++;
        }
        return k;
    }
}
