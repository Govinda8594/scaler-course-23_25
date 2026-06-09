package com.scaler.Scaler.Strings;

import java.util.HashSet;

public class LongestSubstringWithoutCharacterRepeat {
    //    Optimized Version Using ASCII Indexing
    public int lengthOfLongestSubstring(String s) {
        boolean[] seen = new boolean[128]; // ASCII size //Bonus Variant: int[] for Unicode or frequency tracking
        int i = 0, j = 0, maxlen = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (!seen[ch]) {
                seen[ch] = true;
                maxlen = Math.max(maxlen, j - i + 1);
                j++;
            } else {
                seen[s.charAt(i)] = false;
                i++;
            }
        }
        return maxlen;
    }

    public int lengthOfLongestSubstring3(String A) {
        //create HashSet to find the longest substring in the given string without repeating characters
        HashSet<Character> set = new HashSet<>();
        //Initialize ans as 0 because if we give empty string the max length will be 0
        int ans = 0;
        //using two pointers approach start & end point are initizlise as 0
        int start = 0, end = 0;
        while (end < A.length()) {
            if (!set.contains(A.charAt(end))) {//if the char found it will not enter the conditon, if not found it will add it to HashSet
                set.add(A.charAt(end));
                end++;
                ans = Math.max(ans, set.size());//stores the max size of HashSet
            } else {
                set.remove(A.charAt(start));//if same char found in the end it will remove char at the start & increment
                start++;
            }
        }
        return ans;
    }
}
