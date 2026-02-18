package com.scaler.Scaler.Stacks;

import java.util.Arrays;
import java.util.Stack;

//Given an array of integers A.
//        The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
//        Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
public class DifferenceInMaxAndMinElementInAllSubArray {
    //will store index in all these functions

    public int[] findNSEL(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stk.isEmpty() && A[stk.peek()] >= A[i]) {
                stk.pop();
            }

            if (!stk.isEmpty()) {
                ans[i] = stk.peek();
            }
            stk.push(i);
        }
        return ans;
    }

    public int[] findNSER(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        Arrays.fill(ans, len);
        Stack<Integer> stk = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stk.isEmpty() && A[stk.peek()] >= A[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                ans[i] = stk.peek();
            }
            stk.push(i);
        }
        return ans;
    }

    public int[] findNGEL(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stk.isEmpty() && A[stk.peek()] <= A[i]) {
                stk.pop();
            }

            if (!stk.isEmpty()) {
                ans[i] = stk.peek();
            }
            stk.push(i);
        }
        return ans;
    }

    public int[] findNGER(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        Arrays.fill(ans, len);
        Stack<Integer> stk = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stk.isEmpty() && A[stk.peek()] <= A[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                ans[i] = stk.peek();
            }
            stk.push(i);
        }
        return ans;
    }

    public int solve(int[] A) {
        //need to find Nearest Smaller in left, Nearest smallest in right
        //need to find Nearest greater in left, Nearest greater in right
        int[] NSEL = findNSEL(A);
        int[] NSER = findNSER(A);
        int[] NGEL = findNGEL(A);
        int[] NGER = findNGER(A);
        int n = A.length;
        int mod = 1000000007;
        long totalMax = 0L, totalMin = 0L;
        for (int i = 0; i < n; i++) {
            //number of subarrays where A[i] will be maximum
            long maxSubarrayCount = (long) (NGER[i] - i) * (i - NGEL[i]);
            long currentMaxContri = (A[i] * maxSubarrayCount) % mod;
            //number of subarrays where A[i] will be minimum
            long minSubarrayCount = (long) (NSER[i] - i) * (i - NSEL[i]);
            long currentMinContri = (A[i] * minSubarrayCount) % mod;
            //generating total max contribution and minimum contribution
            totalMax = ((currentMaxContri % mod) + (totalMax % mod)) % mod;
            totalMin = ((currentMinContri % mod) + (totalMin % mod)) % mod;
        }
        int sum = (int) (totalMax - totalMin) % mod;
        return (sum + mod) % mod;
    }
}
