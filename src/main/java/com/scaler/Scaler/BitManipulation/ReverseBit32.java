package com.scaler.Scaler.BitManipulation;

public class ReverseBit32 {
    public static void main(String[] args) {
        long ans = reverse(3L);
    }
	public static long reverse(long A) {
        long result = 0;
         for(long i=0; i<32; i++){
             long bit = (A >> i) & 1;
             result = result | (bit<<(31-i));
         }
         return result;
	}
}
