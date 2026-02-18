package com.scaler.Scaler.Sorting;
//Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
public class InversionCount {
//    Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
        public int inversionCount(int[] A) {
            int end = A.length-1,start = 0;
            return inversion(A,start,end);
        }

        int inversion(int[] A,int start,int end){
            int mod = 1000000007;
            if(start >= end) return 0;
            int mid = (start + end)/2;
            int left = inversion(A,start,mid);
            int right = inversion(A,mid+1,end);
            int count = merge(A,start,mid,end);
            return (left+right+count)%mod;
        }

        int merge(int[] A,int start,int mid,int end){
            int p1 = start,p2 = mid + 1,p3 = 0,count = 0;
            int mod = 1000000007;
            int[] temp = new int[end-start+1];
            while(p1 <= mid && p2 <= end){
                if(A[p1] <= A[p2]){
                    temp[p3] = A[p1];
                    p1++;
                }else {
                    count = (count + (mid -p1 + 1))%mod;
                    temp[p3] = A[p2];
                    p2++;
                }
                p3++;
            }

            while(p1 <= mid){
                temp[p3] = A[p1];
                p3++;p1++;
            }

            while(p2<=end){
                temp[p3] = A[p2];
                p2++;p3++;
            }

            for(int i = start;i <= end;i++){
                A[i] = temp[i-start];
            }
            return count;
        }
}
