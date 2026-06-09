package com.scaler.GeeksForGeeks;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        subarraySum(new int[]{0}, 1 ,0);
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>(2);
        int i = 0, j = 0;
        int sum = arr[0];
        if(n == 1 && sum == s){
            ans.add(1);
            ans.add(1);
            return ans;
        }
        while (i < n && j < n) {
            if (i > j) {
                j++;
                sum += arr[j];
            }
            if (sum == s) {
                ans.add(i + 1);
                ans.add(j + 1);
                return ans;
            } else if (sum < s) {
                j++;
                sum += arr[j];
            } else if (sum > s) {
                sum -= arr[i];
                i++;
            }
        }
        ans.add(-1);
        return ans;
    }
}
