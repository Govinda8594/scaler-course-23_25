package com.scaler.Scaler.Pointer;

public class ClosestPalindrome {
    public String closestPalindrome(String A) {
        int p1 = 0;
        int p2 = A.length() - 1;
        int count = 0;
        while (p1 <= p2) {
            if (A.charAt(p1) != A.charAt(p2)) {
                count++;
            }
            p1++;
            p2--;
        }
        if (A.length() % 2 == 1 && count == 0) {
            return "YES";
        }
        return count == 1 ? "YES" : "NO";
    }
}
