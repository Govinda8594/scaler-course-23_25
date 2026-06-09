package com.scaler.Scaler.Strings;

//Given two binary strings A and B,
// count how many cyclic shift of B when taken XOR with A give 0.
//        NOTE: If there is a string, S0, S1, ... Sn-1 ,
//        then it is a cyclic shift is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1
//        where k can be any integer from 0 to N-1.
public class CyclicPermuationOfBStringInAString {
    public int cyclicPermuationOfBStringInAString(String A, String B) {
        int count = 0;
        int patternLen = A.length();
        String patternString = A + "$" + B.substring(0,B.length() - 1);
        //  B + B might work in some case but not for all and return count  - 1
        int[] LPS = computeLPS(patternString);
        int lpsLen = LPS.length;
        for (int i = patternLen; i < lpsLen; i++) {
            if (LPS[i] == patternLen) {
                count++;
            }
        }
        // sometime count-1 will be ans handle edge case for abcd match twice
        return count;
    }

    int[] computeLPS(String str) {
        int n = str.length();
        int[] LPS = new int[n];
        // LPS[0] = 0;
        for (int i = 1; i < n; i++) {
            int x = LPS[i - 1];
            while (str.charAt(i) != str.charAt(x)) {
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
    //////////////////////////////////////////////////////////////////////////////////////

    public int solve(String A, String B) {
        // append B to B to tackle cyclic permutations
        B += B;
        int n = A.length(), m = B.length();
        int lps[] = new int[n];
        computeLPS(lps, A);
        int i = 0, l = 0, ans = 0;
        while (i < m - 1) {
            if (B.charAt(i) == A.charAt(l)) {
                i++;
                l++;
            }
            if (l == n) {
                l = lps[l - 1];
                ans++;
            } else if (i < m && B.charAt(i) != A.charAt(l)) {
                if (l > 0) {
                    l = lps[l - 1];
                } else {
                    i++;
                }
            }
        }
        return ans;
    }

    // function used to longest proper suffix array
    public void computeLPS(int lps[], String s) {
        int n = s.length();
        lps[0] = 0;
        int l = 0, i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(l)) {
                lps[i] = l + 1;
                i++;
                l++;
            } else {
                if (l > 0) {
                    l = lps[l - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    int solve1(String A, String B) {
        int n = B.length();
        int count = 0;
        if (n == 1) {
            return A.equals(B) ? 1 : 0;
        }

        String str = B + B;
        for (int i = 0; i < n; i++) {
            if (A.equals(str.substring(i, i + n))) {
                count++;
            }
        }
        return count;
    }
    public int solve2(String A, String B) {
        int N = A.length();
        int M = B.length();
        int count = 0 ;
        String val = B+B;
        int start = 0,end = N ;
        while(end<2*M){
            String temp = val.substring(start,end);
            if(temp.equals(A)) count++;
            start++;
            end++;
        }
        return count;
    }
}
