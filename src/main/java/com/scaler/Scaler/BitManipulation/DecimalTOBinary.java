package com.scaler.Scaler.BitManipulation;

public class DecimalTOBinary {
    public static void main(String[] args) {
//        anyBaseTodecimal(3,22);
//        decimaltoAnyBase(20,2);
        DecimalToAnyBase(20,2);
    }
    private static void anyBaseTodecimal(int base,long N) {
        long digit = 0;
        long ans = 0,pow = 0;
        while(N !=0){
            digit = N % (long)10;
            ans += digit*(long)Math.pow(base,pow);
            N = N / 10;
            pow++;
        }
        System.out.print(ans);
    }
    static int decimaltoAnyBase(int A,int base){
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

    public static int DecimalToAnyBase(int A, int B) {
        StringBuilder ans = new StringBuilder();
        if(A == 0)
            return 0;
        while(A > 0)   {
            ans.append(A%B);
            A=A/B;
        }
        return Integer.valueOf(ans.reverse().toString());
    }

}
