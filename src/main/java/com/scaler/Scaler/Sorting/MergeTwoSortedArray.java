package com.scaler.Scaler.Sorting;

public class MergeTwoSortedArray {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int[] solve(final int[] A, final int[] B) {
            int n = A.length,m = B.length,p1 = 0,p2= 0,p3 = 0;
            int[] ans = new int[n+m];
            while(p1 < n && p2 < m){
                if(A[p1] < B[p2]){
                    ans[p3] = A[p1];
                    p1++;p3++;
                }
                else{
                    ans[p3] = B[p2];
                    p3++;p2++;
                }
            }
            while(p1 < n){
                ans[p3] = A[p1];
                p3++;p1++;
            }
            while(p2 < m){
                ans[p3] = B[p2];
                p2++;p3++;
            }
            return ans;
        }

}
