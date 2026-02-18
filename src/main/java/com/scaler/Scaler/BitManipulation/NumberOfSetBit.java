package com.scaler.Scaler.BitManipulation;

public class NumberOfSetBit {
    public static void main(String[] args) {
        System.out.println(new NumberOfSetBit().numSetBits(11));
    }
    public int numSetBits(int A) {
        int ans = 0;
        while(A > 0){
            ans = ans + (A&1);
            A = A >> 1;
        }
        return ans;
    }
    public int numSetBits2(int A) {
        int count=0;
        for(int i = 0;i<=30;i++){
            if(((A>>i) & 1) == 1)
                count++;
        }
        return count;
    }
}
