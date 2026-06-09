package com.scaler.Scaler.Hashing;

import java.util.HashMap;
import java.util.Map;

public class MinimumLengthStringOfBInA {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Frequency map for t
        int[] tFreq = new int[128]; // ASCII
        for (char ch : t.toCharArray()) {
            tFreq[ch]++;
        }

        int required = t.length(); // total chars we need to match
        int left = 0, minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If this char is needed, reduce required count
            if (tFreq[ch] > 0) {
                required--;
            }
            tFreq[ch]--; // decrement freq (can go negative if extra chars)

            // When all chars matched, try to shrink window
            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                tFreq[leftChar]++; // put back the left char
                if (tFreq[leftChar] > 0) {
                    required++; // we lost a needed char
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean check(int[] a, int[] b) { // check for every substring if all character of b in a
        for (int i = 0; i < 128; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow3(String A, String B) {
        int[] counta = new int[128];
        int[] countb = new int[128];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < B.length(); i++) {
            int index = B.charAt(i) - ' ';
            countb[index]++;
        }
        int s = 0;
        int e = 0;
        int[] p = new int[2];
        while (e <= A.length() && s <= A.length() && s <= e) {
            if (!check(counta, countb)) {
                // check for every substring if all character of b in a,
                // if not then continue to update frequency of character in substring till eth index
                if (e == A.length()) {
                    break;
                }
                int index = A.charAt(e) - ' ';
                counta[index]++;
                e++;
            } else {
                // if all character found then shink window and the update frequency and minlength
                if (s == A.length()) {
                    break;
                }
                int index = A.charAt(s) - ' ';
                counta[index]--;
                if (ans > (e - s + 1)) { // update minlength
                    ans = (e - s + 1);
                    p[0] = s;
                    p[1] = e;
                }
                s++;
            }
        }
        if (ans == Integer.MAX_VALUE) {
            String ss = new String("");
            return ss;
        }
        return A.substring(p[0], p[1]);
    }
    ///////////////////////////////////////////////////////////////////////////

    public String minWindow4(String A, String B) {
        int b = B.length();// length of B
        int a = A.length();// length of A
        HashMap<Character, Integer> bFreq = new HashMap<>(); // freq map for B
        HashMap<Character, Integer> aFreq = new HashMap<>();// freq map for A
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
// creating a freq hashmap for b
        for (int i = 0; i < b; i++) {
            char str = B.charAt(i);
            bFreq.put(str, bFreq.getOrDefault(str, 0) + 1);
        }
// travering string A and finding the minimum length of string B
        for (int right = 0; right < a; right++) {
            char ch = A.charAt(right);
            aFreq.put(ch, aFreq.getOrDefault(ch, 0) + 1);
            while (check(aFreq, bFreq)) {
                int temp = ans; // temp variable to update the start and end substring
                ans = Math.min(ans, right - left + 1);
                if (temp != ans) {
                    start = left;
                    end = right;
                }
                char tchar = A.charAt(left);
                left++;
                aFreq.put(tchar, aFreq.get(tchar) - 1);// remove a single occurence for the char from A freq
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return "";
        }
        return A.substring(start, end + 1); // Adjusted end index
    }

    // check function for freq A and B
    public boolean check(HashMap<Character, Integer> aFreq, HashMap<Character, Integer> bFreq) {
        for (Map.Entry<Character, Integer> entry : bFreq.entrySet()) {
            Character val = entry.getKey();
// condition to check every occurence of b freq char is >= A freq char
            if (aFreq.getOrDefault(val, 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
