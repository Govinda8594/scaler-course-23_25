package com.scaler.Scaler.Sorting;

import java.util.Arrays;

public class NobleInteger {
    public static void main(String[] args) {
        int ele = bruteforceisNobleIntegerPresent(new int[]{5,6,4,3,2,2});
    }


    static int bruteforceisNobleIntegerPresent(int[]A){
       int len = A.length;
       for(int i=0;i<len;i++){
           int count = 0;
           for(int j=0;j<len;j++){
               if(A[i] < A[j])
                   count++;
           }
           if(count == A[i])
               return 1;
       }

        return -1;
    }

    static int bruteforceisNobleInteger(int[]A){
        int len = A.length,ans = 0;
        for(int i=0;i<len;i++){
            int count = 0;
            for(int j=0;j<len;j++){
                if(A[i] < A[j])
                    count++;
            }
            if(count == A[i])
                ans++;
        }

        return ans;
    }

    static int NobleInteger(int[]A){
        int len = A.length,count = 0;
        Arrays.sort(A);
        for(int i=0;i<len;i++){
            if(i == A[i])
                count++;
        }

        return count;
    }

    static int countofNobleInteger(int[]A){
        int len = A.length;
        Arrays.sort(A);
        int lessthan = 0,count = 0;
        if(A[0] == 0) lessthan++;
        for(int i=1;i<len;i++){
            if(A[i] != A[i-1])
                lessthan = i;
            if(lessthan == A[i])
                count++;
        }

        return count;
    }
//    Given an integer array A, find if an integer p exists in the array such that
//    the number of integers greater than p in the array equals p.
    public static int isNobleIntegerPresent(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        // all element to left of last index elements are less than 0,so we return 1 as 0 is only noble integer
        if (A[n - 1] == 0)
            return 1;
        for (int i = 0; i < n - 1; i++) {
            //skipping duplicate elements
            // and searching the current element in future indices elements
            if (A[i] != A[i + 1] && A[i] == n - i - 1)
                return 1;
        }
        return -1;
    }

    static int xmod11(String x)
    {
        // code here
            int evensum = 0,oddsum = 0;
            for(int i = 0;i<x.length();i++){
                if(i%2 == 0){
                    evensum += Character.getNumericValue(x.charAt(i));
                }else {
                    oddsum += Character.getNumericValue(x.charAt(i));
                }
            }
            if(oddsum - evensum == 0) return 0;
            return (oddsum-evensum)%11;
    }

}
