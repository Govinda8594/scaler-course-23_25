package com.scaler.Scaler.BitManipulation;

public class Add2BinaryString {
    public String addBinary(String A, String B) {
        int i = A.length() - 1,j = B.length() - 1,carry = 0;
        String ans = "";
        
        while(i >= 0 || j >= 0 || carry > 0){
            int sum = 0;
            if(i >= 0){
                sum += A.charAt(i) - '0';
                i--;
            }
            if(j >=0){
                sum += B.charAt(j) - '0';
                j--;
            }    
            sum += carry;
            int bit = sum % 2;
            carry = sum/2;
            ans += (char)(bit + '0');

        }
        StringBuilder s = new StringBuilder(ans);
        return s.reverse().toString();

    }
}
