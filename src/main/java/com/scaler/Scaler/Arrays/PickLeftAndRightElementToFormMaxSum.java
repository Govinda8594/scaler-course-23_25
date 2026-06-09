package com.scaler.Scaler.Arrays;

public class PickLeftAndRightElementToFormMaxSum {
    public int solve(int[] A, int B) {
        int currentSum = 0,len = A.length,ans = 0;
        for(int i = 0;i<B;i++){
            ans+=A[i];
        }
        currentSum = ans;
        int idx = B - 1;
        for(int j = len-1;j >= len-B;j--){
            currentSum += A[j];
            currentSum -= A[idx];
            idx--;
            ans = Math.max(currentSum,ans);
        }
        return ans;
    }
}
