package com.scaler.Scaler.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestElementIndexFromRight {
    /* Driver program to test insertion sort */
    public static void main(String[] args) {
        int arr[] = {1, 3, 0, 2, 5};
        int n = arr.length;
        NSEIR1(arr, n);
    }

    // Prints smaller elements on left side of every element
    static void NSEIR1(int arr[], int n) {
        // Create an empty stack
        Stack<Integer> S = new Stack<>();
        // Traverse all array elements
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            // Keep removing top element from S while the top
            // element is greater than or equal to arr[i]
            while (!S.empty() && arr[S.peek()] >= arr[i]) {
                S.pop();
            }
            // If all elements in S were greater than arr[i]
            if (S.empty()) {
                System.out.print("_, ");
            } else //Else print the nearest smaller element
            {
                System.out.print(S.peek() + ", ");
            }
            // Push this element
            S.push(i);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    public int[] NSEIR(int[] A) {
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


}
