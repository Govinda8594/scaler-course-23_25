package com.scaler.Scaler.Arrays;

public class TripletSumK {
    public int solve(int[] A) {
        int ans = 0;
        int len = A.length;
        for(int i = 0;i<len;i++){
            int l=0,r=0;
            for(int j = i-1;j>=0;j--){
                if(A[j] < A[i])
                    l++;
            }
            for(int k = i+1;k<len;k++){
                if(A[k] > A[i])
                    r++;
            }
            int count = l*r;
            ans += count;
        }
        return ans;
    }

    public int solve2(int[] A) {
        int len = A.length,ans = 0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                for(int k=j+1;k<len;k++){
                    if(A[i] < A[j] && A[j] < A[k]){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
