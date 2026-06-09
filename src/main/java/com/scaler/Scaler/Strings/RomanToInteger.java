package com.scaler.Scaler.Strings;

class RomanToInteger {
    // Finds decimal value of a given roman numeral

    public static void main(String[] args) {
        RomanToInteger roman = new RomanToInteger();
        roman.romanToDecimal("XIXX");
    }
    public int romanToDecimal(String str) {
        // code here
        char[] chs = str.toCharArray();
        int len = chs.length, ans = 0;
        for (int i = len - 1; i >= 0; i -= 2) {
            if (getIntvalue(chs[i - 1]) > getIntvalue(chs[i])) {
                ans += getIntvalue(chs[i]);
            } else {
                ans -= getIntvalue(chs[i]);
            }
        }
        return ans;
    }

    int getIntvalue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}