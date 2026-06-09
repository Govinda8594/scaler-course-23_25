package com.scaler.Scaler.BackTracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//Given a string A and a dictionary of words B, determine if A can be segmented into a space-separated sequence of one or more dictionary words.
//
//        Input Format:
//
//        The first argument is a string, A.
//        The second argument is an array of strings, B.
//        Output Format:
//
//        Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
//        Constraints:
//
//        1 <= len(A) <= 6500
//        1 <= len(B) <= 10000
//        1 <= len(B[i]) <= 20

public class WordBreak {
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
//        wb.wordBreak("myinterviewtrainer",new String[]{"trainer","my","interview"});
        wb.wordBreak2("myinterviewtrainer", new String[]{"trainer", "my", "interview"});
    }

    boolean solve(String A, Set<String> set) {
        if (A.isEmpty()) {
            return true;
        }
        for (int i = 0; i < Math.min(20, A.length()); i++) {
            String str = A.substring(0, i + 1);
            if (set.contains(str) && solve(A.substring(i + 1), set)) {
                return true;
            }
        }
        return false;
    }

    public int wordBreak2(String A, String[] B) {
        return solve(A, new HashSet<>(Arrays.asList(B))) ? 1 : 0;
    }

    ////////////////////////////////////////////////////////////////////////////    ///////
    public int wordBreak(String s, String[] B) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true; // set first to be true, why?
        // Because we need initial state meaning empty string
        Set<String> dict = new HashSet<>(Arrays.asList(B));
        for (int i = 0; i < s.length(); i++) {
            // should continue from match position
            if (!t[i]) {
                continue;
            }
            for (String a : dict) {
                int len = a.length();
                int end = i + len;
                if (end > s.length()) {
                    continue;
                }
                if (t[end]) {
                    continue;
                }
                if (s.substring(i, end).equals(a)) {
                    t[end] = true;
                }
            }
        }
        return t[s.length()] ? 1 : 0;
    }


}
