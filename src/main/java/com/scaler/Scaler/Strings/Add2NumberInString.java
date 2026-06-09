package com.scaler.Scaler.Strings;

public class Add2NumberInString {
    public static void main(String[] args) {
        addString("1230","9");
    }

    static String addString(String A, String B) {
        int i = A.length() - 1;
        int j = B.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += A.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += B.charAt(j--) - '0';
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }
        int k;
        for (k = sb.length() - 1;k >= 0;k--){
            if(sb.charAt(k) != '0')
                    break;
        }
        sb = new StringBuilder(sb.substring(0,k+1));
        if(sb.length() <= 0)
            return "0";
        sb.reverse();
        return sb + "";
    }
}
