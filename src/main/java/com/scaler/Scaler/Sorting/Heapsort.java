package com.scaler.Scaler.Sorting;

public class Heapsort {

    public static void main(String[] args) {
        Heapsort heapsort = new Heapsort();
        int[] A = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        heapsort.heapSort(A);
        for (int x : A
        ) {
            System.out.println(x);
        }
    }

    // Main HeapSort function
    void heapSort(int[] arr) {
        int n = arr.length;
        // 1. Build max-heap from unsorted array (start from last non-leaf node)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);  // Heapify subtree rooted at index i
        }
        // 2. Extract elements from heap one-by-one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (max element) to end
            swap(arr, 0, i);
            // Heapify reduced heap (size = i) with new root
            heapify(arr, i, 0);
        }
    }

    // Heapify subtree rooted at index 'i' to maintain max-heap property
    void heapify(int[] arr, int n, int i) {
        int largest = i;          // Initialize largest as root
        int left = 2 * i + 1;     // Left child index
        int right = 2 * i + 2;    // Right child index
        // If left child exists and is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // If right child exists and is larger than current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);   // Swap root with larger child
            // Recursively heapify affected subtree
            heapify(arr, n, largest);
        }

//        int smallest = i;          // Track smallest element (not largest)
//        int left = 2 * i + 1;
//        int right = 2 * i + 2;
//
//        // Find smallest among node and children
//        if (left < n && arr[left] < arr[smallest])  // Compare: < instead of >
//            smallest = left;
//        if (right < n && arr[right] < arr[smallest]) // Compare: < instead of >
//            smallest = right;
//
//        // If smallest changed, swap and recursively heapify
//        if (smallest != i) {
//            swap(arr, i, smallest);
//            heapify(arr, n, smallest);
//        }
    }

    // Helper function (assumed implementation)
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


//    void heapSort(int[] arr) {
//        int n = arr.length;
//        // Build min-heap (instead of max-heap)
//        for (int i = n / 2 - 1; i >= 0; i--) {
//            heapify(arr, n, i);  // Min-heapify from last non-leaf
//        }
//
//        // Extract smallest and move to end
//        for (int i = n - 1; i > 0; i--) {
//            swap(arr, 0, i);      // Move current root (smallest) to end
//            heapify(arr, i, 0);   // Heapify reduced min-heap
//        }
//    }

}
