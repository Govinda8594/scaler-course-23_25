package com.scaler.Scaler.Strings;

public class BeeslyString {
    public static void main(String[] args) {
        solve("apmmpapam");
    }

    public static int solve(String A) {
        int len = A.length(), acnt = 0 ,pcnt =0,mcnt = 0;
        for(int i = 0;i<len;i++){
            if(A.charAt(i) == 'a') acnt++;
            if(A.charAt(i) == 'p') pcnt++;
            if(A.charAt(i) == 'm') mcnt++;
        }
        if(mcnt == acnt + pcnt){
            return 1;
        }
        return 0;
    }
}
