package com.scaler.Scaler.Strings;

public class TotalSubstringStartingAndEnding1s {
    public static int totalSubstring(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String s2 = s.substring(i, j+1);
                if (s2.charAt(0) == '1' && s2.charAt(s2.length()-1) == '1') {
                    count++;
                }
            }
        }
        return count;
    }

    public static int totalSubstring2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') count++;
        }
        return count * (count + 1)/2;
    }
}
