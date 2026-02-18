package com.scaler.Scaler.Strings;

public class UpperCase {
    public char[] to_upper(char[] A) {
        int len = A.length;
        for(int i = 0;i<len;i++){
            if(A[i] >= 97 && A[i] <= 122){
                A[i] = (char)(A[i] ^ (1 >> 32));
            }
        }
        return A;
    }

    public char[] to_upper1(char[] A) {
        int n = A.length;
        for(int i = 0;i<n;i++){
            if(A[i] >= 97 && A[i] <= 122){
                A[i] = (char)(A[i]-32);
            }
        }
        return A;
    }
}
