package com.scaler.Scaler.Hashing;

import java.util.HashSet;

public class LongestLengthStringWithDistinctCharacter {


    static int length3(String s) {
        int len = s.length(), ans = 0,start = 0,end = 0;
        HashSet<Character> set = new HashSet<Character>();
       while (start < len){
                if (!set.contains(s.charAt(end))) {
                    set.add(s.charAt(end));
                    end++;
                    ans = Math.max(ans, set.size());
                } else {
                    set.remove(s.charAt(start));
                    start++;
                }
            }
        return ans;
    }


    static int length2(String s) {
        int len = s.length(), ans = 0;
        for (int start = 0; start < len; start++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int end = start; end < len; end++) {
                if (!set.contains(s.charAt(end))) {
                    set.add(s.charAt(end));
                } else {
                    break;
                }
                ans = Math.max(ans, set.size());
            }
        }
        return ans;
    }

    static int length(String s) {
        int len = s.length(), ans = 0;
        for (int start = 0; start < len; start++) {
            for (int end = start; end < len; end++) {
                HashSet<Character> set = new HashSet<Character>();
                int subStringlen = end - start + 1;
                for (int k = start; k < end; k++) {
                    set.add(s.charAt(k));
                }
                if (subStringlen == set.size()) {
                    ans = Math.max(ans, subStringlen);
                }
            }
        }
        return ans;
    }
}
