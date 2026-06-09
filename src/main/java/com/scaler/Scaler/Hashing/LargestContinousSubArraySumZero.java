package com.scaler.Scaler.Hashing;

import java.util.HashMap;

//Given an array A of N integers.
//        Find the largest continuous sequence in a array which sums to zero.
public class LargestContinousSubArraySumZero {
    public int[] lszero(int[] A) {
        HashMap<Integer, Integer> indexSum = new HashMap<>(); //HashMap to store (sum,index) pair
        int maxLength = 0;
        int sum = 0;
        int index = -1;
        int startIndex = 0;
        indexSum.put(sum, index);
//First element in the hash map is having sum=0 and index =-1
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (!indexSum.containsKey(sum)) {//If the sum is not present in the HashMap then add it.
                indexSum.put(sum, i);
            } else {//If the sum is present in the HashMap then calculate the length and store the startIndex.
                int len = i - indexSum.get(sum);
                if (len > maxLength) {
                    maxLength = len;
                    startIndex = indexSum.get(sum) + 1;
                }
            }
        }
        int[] ans = new int[maxLength];
        System.arraycopy(A, startIndex, ans, 0, maxLength);
        return ans;
    }
}
