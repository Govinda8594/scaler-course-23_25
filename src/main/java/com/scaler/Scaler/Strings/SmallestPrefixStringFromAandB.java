package com.scaler.Scaler.Strings;
//Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets,
// find the lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
//        Note: The answer string has to start with a non-empty prefix of string
//        A followed by a non-empty prefix of string B.
public class SmallestPrefixStringFromAandB {
    public String smallestPrefix(String A, String B) {
        StringBuilder s = new StringBuilder();
        s.append(A.charAt(0));
        for (int i = 1; i < A.length(); i++) {
            if (A.charAt(i) >= B.charAt(0)) {
                break;
            } else {
                s.append(A.charAt(i));
            }
        }
        s.append(B.charAt(0));
        return s.toString();
    }

    /////////////////////////////////////////////////////////////////
        public String smallestPrefix2(String A, String B) {
            StringBuilder sb = new StringBuilder();
            int aLen = A.length();
            //at least one char should be from A
            sb.append(A.charAt(0));

            for (int i = 1; i < aLen; i++) {
                if ((A.charAt(i) - 'a')<B.charAt(0) - 'a') {
                    sb.append(A.charAt(i));
                } else {
                    break;
                }
            }
            //at least one char should be from B
            sb.append(B.charAt(0));
            return sb.toString();
        }

}
