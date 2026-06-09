package com.scaler.Scaler.Hashing;

import java.util.HashMap;

public class LongestSubStringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 1, len = Integer.MIN_VALUE;
        map.put(A.charAt(0), 0);
        while (end < A.length()) {
            // System.out.println(map+" "+len);
            char ch = A.charAt(end);
            if (map.containsKey(ch) && map.get(ch) >= start) {
                len = Math.max(len, end - start);
                start = map.get(ch) + 1;
            }
            map.put(ch, end);
            end++;
        }
        len = Math.max(len, end - start);
        return len;
    }

    public int lengthOfLongestSubstring2(String A) {
        int count = 0;
        int max = 0;
        int n = A.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char c;
        int prevIndex;
        for (int i = 0; i < n; i++) {
            c = A.charAt(i);
            // hashMap stores the last occurrence of c in A
            if (hashMap.containsKey(c)) {
                prevIndex = hashMap.get(c);
                count = Math.min(count + 1, i - prevIndex);
                hashMap.put(c, i);
            } else {
                count++;
                hashMap.put(c, i);
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
