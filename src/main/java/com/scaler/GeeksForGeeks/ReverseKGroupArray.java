package com.scaler.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseKGroupArray {
    public static void main(String[] args) {
        long A[] = {1, 2, 5, 4, 0};
        int B[] = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        int K = 10;
        reverseInGroups(B, B.length, K);
    }
    //Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        int i = 0;
        while (i < n) {
            if (n - i >= k) {
                Collections.reverse(arr.subList(i, i + k));
                i += k;
            } else {
                Collections.reverse(arr.subList(i, n));
                break;
            }
        }
    }
    void reverseInGroups2(ArrayList<Integer> arr, int n, int k) {
        // Iterate through the array with a step of size k.
        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            // Reverse the sub-array.
            while (left < right) {
                // Swap elements at left and right indices.
                Collections.swap(arr, left, right);
                left++;
                right--;
            }
        }
    }
    void reverseInGroup(ArrayList<Integer> arr, int n, int start, int end) {
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }
    void reverseInGroups3(ArrayList<Integer> arr, int n, int k) {
        // code here
        for (int i = 0; i < n; i += k) {
            if (i + k - 1 < n) {
                reverseInGroup(arr, n, i, i + k - 1);
            } else {
                reverseInGroup(arr, n, i, n - 1);
            }
        }
    }

    static void reverseInGroups(int[] arr, int n, int k) {
        // code here
        int left = 0, right = k - 1;
        if (k > n) {
            reverse(arr, 0, n - 1);
        } else {
            boolean contains = true;
            while (contains) {
                reverse(arr, left, right);
                left = right + 1;
                right = right + k;
                if (right >= n) {
                    right = n - 1;
                    reverse(arr, left, right);
                    contains = false;
                }
            }
        }
//        System.out.println(arr.toString());
    }

    static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }
    ///
    void reverseInGroups4(ArrayList<Integer> arr, int n, int k) {
        // code here
        int i = 0;
        while (i < n) {
            reverse(arr, i, Math.min(i + k - 1, n - 1));
            i = i + k;
        }
    }

    private void reverse(ArrayList<Integer> arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    void reverseInGroups5(ArrayList<Integer> arr, int n, int k) {
        for (int i = 0; i < n - 1; i += k) {
            int low = i;
            int high = i + k - 1;
            if (high > n - 1) {
                high = n - 1;
            }
            while (low < high) {
                int tmp = arr.get(low);
                arr.set(low, arr.get(high));
                arr.set(high, tmp);
                low++;
                high--;
            }
        }
    }
}
