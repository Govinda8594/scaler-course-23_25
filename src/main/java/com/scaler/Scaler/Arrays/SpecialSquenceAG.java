package com.scaler.Scaler.Arrays;

public class SpecialSquenceAG {
    public int solve(String A) {
        int count = 0;
        int ans = 0;
        int len  = A.length();
        int modulo = (int)(Math.pow(10,9) + 7);
        for(int i = len-1;i>=0;i--){
            if(A.charAt(i) == 'G')
                count++;
            if(A.charAt(i) == 'A')
                ans +=count;
            ans = ans % modulo;
        }
        return  ans;
    }
}
