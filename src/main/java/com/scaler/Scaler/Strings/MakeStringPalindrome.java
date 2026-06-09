package com.scaler.Scaler.Strings;

//Given a string A of size N consisting only of lowercase alphabets.
// The only operation allowed is to insert characters in the beginning of the string.
//
//        Find and return how many minimum characters are needed to be inserted
//        to make the string a palindrome string.
public class MakeStringPalindrome {
    public int solve(String A) {
        StringBuilder s = new StringBuilder();
        s.append(A);

        String rev = s.reverse().toString();
        s.reverse().append("@").append(rev);
        int[] lps = createLPS(s.toString(), s.toString().length());
        return A.length() - lps[lps.length - 1];
    }

    public int[] createLPS(String A, int N) {
        int[] lps = new int[N];
        lps[0] = 0;
        for (int i = 1; i < N; i++) {
            int x = lps[i - 1];
            while (A.charAt(i) != A.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }
        return lps;
    }
}
