package com.scaler.Scaler.Strings;

import java.util.HashMap;

//Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
//        Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.
//
//        Note: A = "Aa91b"
// B = "ab"
//
//        If there is no such window in A that covers all characters in B, return the empty string.
//        If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )
public class WindowString {
    public static String minWindow1(String A, String B) {
        if (A.isEmpty() || B.isEmpty()) {
            return ""; // If either string is empty, return an empty string.
        }

        HashMap<Character, Integer> mapB = new HashMap<>(); // Stores character frequencies in B.
        for (char c : B.toCharArray()) {
            mapB.put(c, mapB.getOrDefault(c, 0) + 1); // Populate map with count of each character in B.
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, minStart = 0, count = mapB.size();
        HashMap<Character, Integer> mapA = new HashMap<>(); // Stores character frequencies in the current window of A.

        while (right < A.length()) { // Expand the window by moving the right pointer.
            char rightChar = A.charAt(right);
            mapA.put(rightChar, mapA.getOrDefault(rightChar, 0) + 1); // Update frequency of the rightmost character.

            // If rightChar is in B and its count matches, reduce `count`.
            if (mapB.containsKey(rightChar) && mapA.get(rightChar).equals(mapB.get(rightChar))) {
                count--;
            }

            while (count == 0) { // When all characters are matched, try minimizing the window.
                if (right - left + 1 < minLen) { // Update minimum length and start index.
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = A.charAt(left);
                mapA.put(leftChar, mapA.get(leftChar) - 1); // Remove leftmost character from window.

                // If leftChar was necessary and its count now falls below required, increase `count`.
                if (mapB.containsKey(leftChar) && mapA.get(leftChar) < mapB.get(leftChar)) {
                    count++;
                }
                left++; // Shrink the window from the left.
            }

            right++; // Continue expanding the window.
        }

        return minLen == Integer.MAX_VALUE ? "" : A.substring(minStart, minStart + minLen); // Return the minimum window substring.
    }

    public static void main(String[] args) {
        String A = "ADOBECODEBANC";
        String B = "ABC";
        System.out.println(minWindow1(A, B)); // Output: "BANC"
    }

    public static String minWindow(String A, String B) {
        HashMap<Character, Integer> map = new HashMap<>();
        int need = B.length(), count = 0, start = 0, len = Integer.MAX_VALUE, startIndex = -1;
        int[] frqA = new int[129];
        for (int i = 0; i < B.length(); i++) {
            map.put(B.charAt(i), map.getOrDefault(B.charAt(i), 0) + 1);
        }
        for (int i = 0; i < A.length(); i++) {
            char element = A.charAt(i);
            frqA[element]++;
            if (map.containsKey(element) && frqA[element] <= map.get(element)) {
                count++;
            }
            if (count == need) {
                //  System.out.print(i+" "+start+" "+count+" "+need);
                while (count == need && start <= i) {
                    if (i - start + 1 < len) {
                        len = i - start + 1;
                        startIndex = start;
                    }
                    element = A.charAt(start);
                    frqA[element]--;
                    if (map.containsKey(element) && frqA[element] < map.get(element)) {
                        count--;
                    }
                    start++;
                }
            }
        }
        return startIndex == -1 ? "" : A.substring(startIndex, startIndex + len);
    }
}
