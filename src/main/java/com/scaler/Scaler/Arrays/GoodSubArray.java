package com.scaler.Scaler.Arrays;

public class GoodSubArray {
    public static void main(String[] args) {

//        Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
//        1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
//        2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
//        Your task is to find the count of good subarrays in A.
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
        GoodSubArray(A, 655);
    }
    public static int GoodSubArray(int[] A, int B) {
        int len = A.length, count = 0, sum = 0, i = 0, j = 0;
        while (j < len) {
            sum += A[j];
            if (((j - i + 1) % 2 == 0 && sum < B) || ((j - i + 1) % 2 != 0 && sum > B)) {
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

    public int solve(int[] A, int B) {
        int len = A.length,count = 0;
        for(int i = 0;i<len;i++){
            int sum = 0;
            for(int j = i;j<len;j++){
                sum += A[j];
                if(((j - i + 1) % 2 == 0 && sum < B) || ((j - i + 1) % 2 != 0 &&  sum > B)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int solve1(int[] A, int B) {
        int n = A.length;
        int[] pref = new int[n];
        pref[0] = A[0];
        int ans = 0;
        for(int i = 1 ; i < n ; i++){
            pref[i] = pref[i - 1] + A[i];
        }
        for(int i = 0 ; i < n ; i++){
            for (int j = i ; j < n ; j++){
                int sz = j - i + 1;
                int sum;
                if(i == 0){
                    sum = pref[j];
                }
                else{
                    sum = pref[j] - pref[i - 1];
                }
                if(sz % 2 == 0 && sum < B)ans++;
                if(sz % 2 == 1 && sum > B)ans++;
            }
        }
        return ans;
    }
}
