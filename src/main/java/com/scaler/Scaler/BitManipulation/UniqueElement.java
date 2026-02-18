package com.scaler.Scaler.BitManipulation;
//Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
//
//        NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


public class UniqueElement {
    public int singleNumber(final int[] A) {
        int ans = A[0];
        for(int j = 1;j<A.length;j++){
            ans = ans ^ A[j];
        }
        return ans;
    }

    public int singleNumber2(final int[] A) {
        int ans = 0;
        int c;
        for(int i = 0;i<=30;i++){
            c = 0;
            for(int j = 0;j<A.length;j++){
                int bool = (A[j]>>i) & 1;
                if(bool == 1)
                    c++;
            }
            if(c % 2 == 1)
                ans += (1 << i);
        }
        return ans;
    }
}
