package com.scaler.Scaler.Arrays;

public class GenerateNoThatAsNoFollowedByBsNo {
//    5,3
//    11111000
    int solve(int A,int B){
        int ans = 0;
        for(int i = B;i<A+B;i++){
            int lastbit = 1 << i;
            ans = ans | lastbit;
        }
        return ans;
    }
}
