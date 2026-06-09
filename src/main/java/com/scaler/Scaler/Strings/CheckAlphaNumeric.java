package com.scaler.Scaler.Strings;

public class CheckAlphaNumeric {
    public static void main(String[] args) {
        int ans = isAlphaNumeric(new char[]{'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'});
    }

    public static int withpattern(char[] A) {
        String temp = new String(A);
        if (temp.matches("[A-Za-z0-9]*")) return 1;
        return 0;
    }

    static int isAlphaNumeric(char[] A) {
        int len = A.length;
        for (char c : A) {
            if (!((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57))) {
                return 0;
            }
        }
        return 1;
    }
}
