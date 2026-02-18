package com.scaler.Scaler.Combinatrics;
//Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
//        Assume that no characters are repeated.
//        Note: The answer might not fit in an integer, so return your answer % 1000003
public class RankOfString {
    int mod = 1000003;

    public int findRank(String A) {
        int len = A.length();
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                if (A.charAt(j) < A.charAt(i))
                    count++;
            }
            ans = ans + (count * fact(len - i - 1)) % mod;
        }
        return (ans + 1) % mod;
    }

    int fact(int n) {
        if (n == 0 || n == 1) return 1;
        return (n * fact(n - 1)) % mod;
    }

}
