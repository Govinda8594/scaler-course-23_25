package com.scaler.Scaler.Strings;

public class AddBinaryString {
    public static void main(String[] args) {
        getBinaryString("1100","1101");
    }

    static String getBinaryString(String A,String B){
        int lenA  = A.length()-1,lenB = B.length()-1,carry = 0;
        StringBuilder ans = new StringBuilder();
        while(lenA >= 0 || lenB>=0 || carry > 0){
            int sum = carry;
            if(lenA >= 0){
                sum += A.charAt(lenA) - '0';
                lenA--;
            }

            if(lenB >= 0){
                sum += B.charAt(lenB) - '0';
                lenB--;
            }
            ans.append((char)('0' + sum % 2));
            carry = sum/2;
        }
        return ans.reverse().toString();
    }
}
