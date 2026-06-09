package com.scaler.Scaler.Arrays;

import java.util.Arrays;

public class Mindistancecow {
        public int solve(int[] A, int B) {
            int len = A.length;
            Arrays.sort(A);
            int ans = -1,maxdistance = A[len - 1];
            int low = 1,high = maxdistance;
            while(low<=high){
                int mid = (low+high)/2;
                if(ispossible(A,mid,len,B)){
                    ans= mid;
                    low = mid + 1;
                }else high = mid - 1;
            }
            return ans;
        }

        boolean ispossible(int[] A,int dist,int n,int C){
            int count = 1;
            int prev = A[0];
            for(int i = 0;i<n;i++){
                int curr = A[i];
                if(curr - prev >= dist){
                    prev = curr;
                    count++;
                }
            }
            if(count >= C){
                return true;
            }

            return false;
        }

}
