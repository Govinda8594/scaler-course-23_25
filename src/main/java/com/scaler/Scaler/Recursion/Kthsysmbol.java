package com.scaler.Scaler.Recursion;

//On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
//
//        Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.).
public class Kthsysmbol {
//    Row 1: 0      -> 2^(n-1) -> 2^(n-1)/2
//    Row 2: 0 | 1     -> 2^(n-2)
//    Row 3: 01 | 10
//    Row 4: 0110 | 1001

    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int ans = kth(5, 8);
    }

    static int Kthsysmbol(int A, int B) {
        if (B == 0 || A == 1) {
            return 0;
        }
        int mid = (1 << (A - 1)) / 2; //length of elements in row A which will be 2^(A-1) ==>/2 check the start of partition in number from previous number
//        int mid = ((int)(Math.pow(2,A-1))) / 2;
        if (B < mid)         //if B is in the first half, it will be the same symbol on the same index of prev row
        {
            return Kthsysmbol(A - 1, B);
        } else                      //if B is in the second half, it will be the opposite symbol on the prev row at B - mid index position
        {
            return 1 - Kthsysmbol(A - 1, B - mid);
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    static int Kthsysmbol1(int A, int B) {
        if (B == 0 || A == 1) {
            return 0;
        }
        return Kthsysmbol1(A, B >> 1) + B & 1;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // brute force;
    static int kth(int A, int B) {
        if (B == 0 || A == 1) {
            return 0;
        }
        String sb = "0";
        for (int i = 1; i < A; i++) {
            String newsb = "";
            int newlen = 0;
            newlen = sb.length();
            for (int j = 0; j < newlen; j++) {
                if (sb.charAt(j) == '0') {
                    newsb = newsb.concat("0").concat("1");
                } else {
                    newsb = newsb.concat("1").concat("0");
                }
            }
            sb = newsb;
        }
        if (B > sb.length()) {
            return sb.charAt(sb.length() - 1);
        }
        return sb.charAt(B) - '0';
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve(int A, int B) {
        if (A == 1) {
            sb = new StringBuilder("0");
            return 0;
        }
        int temp = solve(A - 1, B);
        int i = 0;
        StringBuilder sb1 = new StringBuilder();
        while (i < sb.length()) {
            if (sb.charAt(i) == '0') {
                sb1.append("01");
            } else {
                sb1.append("10");
            }
            i++;
        }
        sb = sb1;
        return ((sb.length() >= B) ? (sb.charAt(B - 1) - '0') : (sb.charAt(sb.length() - 1) - '0'));
    }
}
