package com.scaler.Scaler.Strings;

public class ToggleCharacterCase {
    public static void main(String[] args) {
//to_upper1(new char[]{'S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'});
        to_lower1(new char[]{'S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'});

    }
    static char[] to_upper(char[] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] >= 97 && A[i] <= 122) {
//                A[i] = (char) (A[i] ^ 32);
                A[i] = (char) (A[i] ^ (1<<5));
            }
        }
        return A;
    }

    static char[] to_upper1(char[] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] >= 97 && A[i] <= 122) {
                A[i] = (char) (A[i] - 32);
            }
        }
        return A;
    }

    static char[] to_lower(char[] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] >= 65 && A[i] <= 90) {
                A[i] = (char) (A[i] + 32);
            }
        }
        return A;
    }

    static char[] to_lower1(char[] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] >= 65 && A[i] <= 90) {
                A[i] = (char) (A[i] | 32);
//                A[i] = (char) (A[i] | (1<<5));
            }
        }
        return A;
    }
}
