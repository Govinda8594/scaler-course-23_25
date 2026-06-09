package com.scaler.Scaler.DynamicProgramming;

//Implement wildcard B matching with support for ' ? ' and ' * ' for strings A and B.
//        ' . ' : Matches any single character.
//        ' * ' : Matches zero or more of the preceding element. >= 0
//        The matching should cover the entire input string (not partial).
//    Problem Constraints
//        1 <= length(A), length(B) <= 104
//  Input Format
//        The first argument of input contains a string A.
//        The second argument of input contains a string B denoting the B.
//   Output Format
//        Return 1 if the Bs match else return 0.
public class RegularExpression2 {
    Boolean[][] dp;
    ///////////////////////Easy - Tabulation|| Top-Down////////////////////////////////////////

    public int isMatch3(final String A, final String B) {
        boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (i == 0 && j == 2 && B.charAt(j - 1) == '*') {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    char a = A.charAt(i - 1);
                    char b = B.charAt(j - 1);
                    if (b == '.' || a == b) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (b == '*') {
                        char b1 = B.charAt(j - 2);
                        if (b1 == '.') {
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                        } else {
                            dp[i][j] = dp[i][j - 2] || (a == b1 && dp[i - 1][j]);
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[A.length()][B.length()] ? 1 : 0;
    }

    public int isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, etc. that can match empty string
        for (int j = 2; j <= m; j++) {
            if (B.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
//        - * can:
//        - Match zero occurrences: dp[i][j - 2]
//                - Match one or more if previous character matches: dp[i - 1][j]
//                - . matches any character

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char aChar = A.charAt(i - 1);
                char bChar = B.charAt(j - 1);

                if (bChar == '.' || bChar == aChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (bChar == '*') {
                    char prev = B.charAt(j - 2);
                    if (prev == '.' || prev == aChar) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }

        return dp[n][m] ? 1 : 0;
    }

    ////////////////////////////////////bottom - up////////////////////////////////////////////////////////////////////////////////
    public int isMatch5(final String A, final String B) {
        int n = A.length();
        int m = B.length();
        dp = new Boolean[n][m];
        return check(n - 1, m - 1, A, B) ? 1 : 0;
    }

    public boolean check(int i, int j, String A, String B) {
//        Base Cases:
//        - i < 0 && j < 0: both strings exhausted → match ✅
//        - j < 0: pattern exhausted but input remains → mismatch ❌
//        - i < 0: input exhausted but pattern remains → only valid if pattern is made of ' ' pairs

        if (i < 0 && j < 0) {
            return true;
        }
        if (j < 0) {
            return false;
        }
        if (i < 0) {
            for (int k = j; k >= 0; k -= 2) {
                if (B.charAt(k) != ' ') {
                    return false;
                }
            }
            return true;
        }
        //memoization
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (A.charAt(i) == B.charAt(j) || B.charAt(j) == '.') {
            dp[i][j] = check(i - 1, j - 1, A, B);
            // both B.charAt(j - 1) == A.charAt(i) || B.charAt(j - 1) == '.') match for single character
        } else if (B.charAt(j) == ' ' && (B.charAt(j - 1) == A.charAt(i) || B.charAt(j - 1) == '.')) {
//            - Two choices:
//            - Use ' ' to match current character → move i - 1, keep j
//                    - Skip ' ' and its preceding character → move j - 2
            dp[i][j] = check(i - 1, j, A, B) | check(i, j - 2, A, B);
        } else if (B.charAt(j) == '*' && B.charAt(j - 1) != A.charAt(i)) {
//            - Wildcard ' ' but no match
//            - Skip ' * ' and its preceding character → move j - 2
            dp[i][j] = check(i, j - 2, A, B);
        } else {
            dp[i][j] = false;
        }
        return dp[i][j];
    }
}
