package com.scaler.Scaler.BitManipulation;

public class ConstructBinaryNumber {
    public static void main(String[] args) {
//        1111100000 => A's no of 1's followed by B's no of zeros
        constructBinaryNumber(5,5);
    }
    public static int solve(int A, int B) {
        int len = A + B,ans = 0;
        for(int i = 0;i < len;i++){
            if(i < B){
                ans += 0 *Math.pow(2,i);
            }else ans += 1 * Math.pow(2,i);
        }
        return ans;
    }

    public static int constructBinaryNumber(int A, int B) {
        int len = A + B,ans = 0;
        for(int i = B;i < len;i++) {
            int lastbit = 1 << i;
            ans += lastbit;
        }
        return ans;
    }
}
