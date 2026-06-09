package com.scaler.Scaler.Sorting;

import java.util.Arrays;

//Given an array A of non-negative integers, arrange them such that they form the largest number.
//        Note: The result may be very large, so you need to return a string instead of an integer.
public class FormLargestNumber {
    public static void main(String[] args) {
        getFormLargestNumber(new int[]{3, 30, 34, 5, 9});
    }

    static String getFormLargestNumber(int[] A) {
        int len = A.length;
        String[] s = new String[len];
        for (int i = 0; i < len; i++) {
            s[i] = Integer.toString(A[i]);
        }
        Arrays.sort(s, (a, b) -> {
            String num1 = a + b;
            String num2 = b + a;
            // a = 5,b = 9 ==> 59(ab) > 95(ba) -> return -1 i.e 95(ba)
            // [9,5,...]
            if (Long.parseLong(num1) > Long.parseLong(num2)) {
                return -1;
            }
            return 1;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(s[i]);
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
