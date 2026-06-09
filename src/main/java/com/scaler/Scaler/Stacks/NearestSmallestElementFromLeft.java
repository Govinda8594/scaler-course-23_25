package com.scaler.Scaler.Stacks;

import java.util.Arrays;
import java.util.Stack;

//Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
//        More formally,
//        G[i] for an element A[i] = an element A[j] such that
//        j is maximum possible AND
//        j < i AND
//        A[j] < A[i]
//        Elements for which no smaller element exist, consider the next smaller element as -1.
public class NearestSmallestElementFromLeft {
    /* Driver program to test insertion sort */
    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 2, 5};
        int n = arr.length;
        NSEL(arr, n);
    }

    // Prints smaller elements on left side of every element
    static void NSEL(int arr[], int n) {
        // Create an empty stack
        Stack<Integer> S = new Stack<>();
        // Traverse all array elements
        for (int i = 0; i < n; i++) {
            // Keep removing top element from S while the top
            // element is greater than or equal to arr[i]
            while (!S.empty() && S.peek() >= arr[i]) {
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
            S.push(arr[i]);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    public int[] NSEL(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < len; i++) {
            // pop all element ,if encounter greater element on-left from current ith element
            while (!stk.isEmpty() && stk.peek() >= A[i]) {
                stk.pop();
            }
            // smaller element for the current i
            if (!stk.isEmpty()) {
                ans[i] = stk.peek();
            }
            // always push ith element
            stk.push(A[i]);
        }
        return ans;
    }
}
