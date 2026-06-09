package com.scaler.Scaler.Arrays;

public class CountOfSubArraySumLessThanGivenB {
    public int solve(int[] A, int B) {
        int len = A.length, count = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += A[j];
                if (sum < B) count++;
            }
        }
        return count;
    }

    public int solve2(int[] A, int B) {
        int len = A.length, count = 0, j = 0, i = 0, sum = 0;
        while (j < len && i < len) {
            sum += A[j];
            if (sum < B) {
                count++;
            }
            j++;
            if (j == len) {
                i++;
                j = i;
                sum = 0;
            }
        }
        return count;
    }

    public int solve1(int[] A, int B) {
        int n  = A.length;
        int[] pref = new int[n];
        pref[0]=A[0];
        int ans=0;
        for(int i=1;i<n;i++)pref[i]=pref[i-1]+A[i];
        for(int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                int sum = pref[j];
                if(i>0){
                    sum -= pref[i-1];
                }
                if(sum < B) ans++;
            }
        }
        return ans;
    }

}
