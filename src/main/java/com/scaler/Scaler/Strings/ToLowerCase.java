package com.scaler.Scaler.Strings;

public class ToLowerCase {
    public char[] to_lower(char[] A) {
        int n = A.length;
        for(int i = 0;i<n;i++){
            if(A[i] >= 65 && A[i] <= 90){
                A[i] = (char)(A[i]+32);
            }
        }
        return A;
    }
}
