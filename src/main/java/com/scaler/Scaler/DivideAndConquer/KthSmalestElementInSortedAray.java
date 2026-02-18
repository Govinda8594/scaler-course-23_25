package com.scaler.Scaler.DivideAndConquer;// Java Program to find kth element
// from two sorted arrays
// Time Complexity: O(log k)

import java.util.Arrays;

class KthSmalestElementInSortedAray {
    static int kth(int arr1[], int m, int arr2[], int n,
                   int k) {
        if (k > (m + n) || k < 1)
            return -1;
        // let m > n
        if (m > n)
            return kth(arr2, n, arr1, m, k);
        // Check if arr1 is empty returning
        // k-th element of arr2
        if (m == 0)
            return arr2[k - 1];
        // Check if k = 1 return minimum of first
        // two elements of both arrays
        if (k == 1)
            return Math.min(arr1[0], arr2[0]);
        // Now the divide and conquer part
        int i = Math.min(m, k / 2);
        int j = Math.min(n, k / 2);
        if (arr1[i - 1] > arr2[j - 1]) {
            // Now we need to find only k-j th element
            // since we have found out the lowest j
            int temp[] = Arrays.copyOfRange(arr2, j, n);
            return kth(arr1, m, temp, n - j, k - j);
        }
        // Now we need to find only k-i th element
        // since we have found out the lowest i
        int temp[] = Arrays.copyOfRange(arr1, i, m);
        return kth(temp, m - i, arr2, n, k - i);
    }

    // Driver code
    public static void main(String[] args) {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int m = arr1.length;
        int n = arr2.length;
        int k = 5;
        int ans = kth(arr1, m, arr2, n, k);
        if (ans == -1)
            System.out.println("Invalid query");
        else
            System.out.println(ans);
    }

    static int kth(int arr1[], int arr2[], int m,
                   int n, int k, int st1, int st2) {
        // In case we have reached end of array 1
        if (st1 == m) {
            return arr2[st2 + k - 1];
        }
        // In case we have reached end of array 2
        if (st2 == n) {
            return arr1[st1 + k - 1];
        }
        // k should never reach 0 or exceed sizes
        // of arrays
        if (k == 0 || k > (m - st1) + (n - st2)) {
            return -1;
        }
        // Compare first elements of arrays and return
        if (k == 1) {
            return (arr1[st1] < arr2[st2])
                    ? arr1[st1] : arr2[st2];
        }
        int curr = k / 2;
        // Size of array 1 is less than k / 2
        if (curr - 1 >= m - st1) {
            // Last element of array 1 is not kth
            // We can directly return the (k - m)th
            // element in array 2
            if (arr1[m - 1] < arr2[st2 + curr - 1]) {
                return arr2[st2 + (k - (m - st1) - 1)];
            } else {
                return kth(arr1, arr2, m, n, k - curr,
                        st1, st2 + curr);
            }
        }
        // Size of array 2 is less than k / 2
        if (curr - 1 >= n - st2) {
            if (arr2[n - 1] < arr1[st1 + curr - 1]) {
                return arr1[st1 + (k - (n - st2) - 1)];
            } else {
                return kth(arr1, arr2, m, n, k - curr,
                        st1 + curr, st2);
            }
        } else
            // Normal comparison, move starting index
            // of one array k / 2 to the right
            if (arr1[curr + st1 - 1] < arr2[curr + st2 - 1]) {
                return kth(arr1, arr2, m, n, k - curr,
                        st1 + curr, st2);
            } else {
                return kth(arr1, arr2, m, n, k - curr,
                        st1, st2 + curr);
            }
    }
}
