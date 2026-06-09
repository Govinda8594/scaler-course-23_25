package com.scaler.Scaler.Arrays;

public class LengthOfLongestConsecutive1s {
    public int solve(String A) {
        int len = A.length();
        int count = 0;
        for(int i = 0;i<len;i++){
            if(A.charAt(i) == '1')
                count++;
        }
        if(count == len) return len;
        if(count == 0) return 0;
        int ans = 0;
        for(int i = 0;i<len;i++){
            if(A.charAt(i) == '0'){
                int l = 0,r = 0;
                for(int j = i-1;j>=0;j--){
                    if(A.charAt(j) == '1')
                        l++;
                    else
                        break;
                }

                for(int j = i+1;j<len;j++){
                    if(A.charAt(j) == '1')
                        r++;
                    else
                        break;
                }
                int c = 0;
                if (count > l + r) {
                    c = l + r + 1;
                } else {
                    c = l + r;
                }
                if(c > ans)
                    ans = c;
            }
        }
        return ans;
    }

    void toBinary(int N) {
        //Write your code here
        StringBuilder str = new StringBuilder();
        while(N != 0){
            str.append((char)((N%2)+'0'));
            N /= 2;
        }

        System.out.print(str);
    }
}
