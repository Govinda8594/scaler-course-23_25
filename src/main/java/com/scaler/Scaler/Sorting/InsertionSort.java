package com.scaler.Scaler.Sorting;

public class InsertionSort {
    /// ///////////////////////////////////////////////////////
//    Optimizations:
//    Binary Search: Finds insertion index in O(log n) vs O(n) comparisons.
//    Bulk Shift: Uses System.arraycopy() (native JVM op) for efficient shifting.
//    Time Complexity:
//    Comparisons: O(n log n)
//    Shifts: O(n²) (asymptotic unchanged, but faster in practice)
//    Best For: Expensive comparisons (e.g., strings, complex objects).
//Provided input no duplicate element
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] A = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        insertionSort.OptimizedbinaryInsertionSort(A);
        for (int x : A
        ) {
            System.out.println(x);
        }
    }

    //    Time Complexity:
//
//    Best: O(n) (already sorted)
//
//    Worst/Avg: O(n²)
//
//    Space: O(1) (in-place)
//
//    Stable: Yes
    // compare with Key
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i;
            // Shift elements > key to the right
            while (j > 0 && arr[j - 1] > key) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = key; // Insert key
        }
    }

    public void OptimizedbinaryInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int pos = binarySearch(arr, key, 0, i - 1);
            // Shift elements from pos to i-1
            System.arraycopy(arr, pos, arr, pos + 1, i - pos);
            arr[pos] = key; // Insert key
        }
    }

    private int binarySearch(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return low; // Position to insert
    }
}
