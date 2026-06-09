package com.scaler.Scaler.BitManipulation;

public class AnyBaseToDecimal {
    public int solve(int A, int B) {
        int temp = 0,p = 0,cal = 0;
        while(A>0){
            temp = A % 10;
            cal += temp * (int)Math.pow(B,p);
            A = A/10;
            p++;
        }
        return cal;
    }

    public int DecimalToAnyBase(int A, int base) {
        int ans = 0;
        int m = 1;
        int remainder = 0;
        while(A != 0){
            remainder = A % base;
            ans += remainder*m;
            A = A / base;
            m *= 10;
        }
        return ans;
    }
}
