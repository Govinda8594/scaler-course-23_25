package com.scaler.Scaler.Strings;

public class LongestCommonPrefix {
//    Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.
//    The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
//            Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
    public static void main(String[] args) {
//        longestCommonPrefix(new String[]{"abab", "ab", "abcd"});

        longestCommonPrefixlen(new String[]{"abab", "ab", "abcd"});
    }

    static String longestCommonPrefix1(String[] A) {
        int len = A.length;
        String[] prefix = new String[len];
        prefix[0] = A[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = commonPrefix(prefix[i - 1], A[i]);
        }
        // if want to return common len
        int ans = prefix[len - 1].length();
        return prefix[len - 1];
    }

    static String commonPrefix(String A, String B) {
        int len = Math.min(A.length(), B.length());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (A.charAt(i) != B.charAt(i))
                break;
                ans.append(A.charAt(i));
        }
        return ans.toString();
    }

    public String longestCommonPrefix(String[] A) {
        String ans ="";
        if(A.length ==0) return ans;
        ans = A[0];
        for(int i = 1;i<A.length;i++){
            ans = CommonPrefix(ans,A[i]);
            if(ans.length() == 0) break;
        }
        return ans;
    }

    private String CommonPrefix(String A,String B){
        int len = Math.min(A.length(), B.length());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (A.charAt(i) != B.charAt(i))
                break;
            ans.append(A.charAt(i));
        }
        return ans.toString();
    }

    static int longestCommonPrefixlen(String[] A) {
        int len = A.length;
        int[] prefix = new int[len-1];
        for (int i = 0; i+1 < len; i++) {
            prefix[i] = commonPrefixlen(A[i], A[i + 1]);
        }
        return prefix[len-2];
    }

    static int commonPrefixlen(String A, String B) {
        int len = Math.min(A.length(), B.length());
        int commonlen = 0;
        for (int i = 0; i < len; i++) {
            if (A.charAt(i) == B.charAt(i))
                commonlen++;
        }
        return commonlen;
    }
}
