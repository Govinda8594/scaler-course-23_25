package com.scaler.Scaler.Pointer;

import java.util.HashMap;

public class MinimumLengthStringOfBinA {

    public boolean isValid(HashMap<Character, Integer> hm) {
        for (char c : hm.keySet()) {
            if (hm.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
    public String minWindow(String A, String B) {
        //Create hashmap for String b with -ve frequency
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            if (hm.containsKey(ch)) {
                int val = hm.get(ch);
                hm.put(ch, val - 1);
            } else {
                hm.put(ch, -1);
            }
        }
        //take pointers at 0,0 and start and end pointers to save the substring index
        int p1 = 0, p2 = 0, start = -1, end = -1;
        //take the string A and iterate
        while (p2 < A.length()) {
            //1)))  increment frequency of A[p2] in map if exists
            char ch = A.charAt(p2);
            if (hm.containsKey(ch)) {
                int val = hm.get(ch);
                hm.put(ch, val + 1);
            }
            //2)) check if the hashmap is valid
            while (isValid(hm)) {
                if (start == -1 || p2 - p1 + 1 < end - start + 1) {
                    start = p1;
                    end = p2;
                }
                //decrement frequency of p1 in map if exists
                char c = A.charAt(p1);
                if (hm.containsKey(c)) {
                    int val = hm.get(c);
                    hm.put(c, val - 1);
                }
                p1++;
            }
            //increment p2
            p2++;
        }
        if (start == -1 || end == -1) {
            return "";
        }
        return A.substring(start, end + 1);
    }
}
