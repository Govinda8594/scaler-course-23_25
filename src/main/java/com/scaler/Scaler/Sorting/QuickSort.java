package com.scaler.Scaler.Sorting;

public class QuickSort {
    //method to get the actual index of a pivot by rearranging

    public static int rearrange(int[] A, int s, int e) {
        //    Partition the array into two subarrays:
        //    one containing elements smaller than the pivot element,
        //    and one containing elements larger than the pivot element.
        // s (index) is pivot
        int p1 = s + 1;
        int p2 = e;
        while (p1 <= p2) {
            if (A[p1] < A[s]) { // find greater element on right side wrt to pivot from pivot + 1, reverse logic to move pointer p1
                p1++;
            } else if (A[p2] > A[s]) { // find smaller element on left side wrt to pivot from end, reverse logic to move pointer p2
                p2--;
            } else { // when found greater element on right and smaller element from left side and p1 and p2 did not cross each other
                // then swap A[p1] and A[p2]
                swap(A, p1, p2);
                //  int temp=A[p1];
                //  A[p1]=A[p2];
                //  A[p2]=temp;
                p1++;
                p2--;
            }
        }
        // when p1 and p2 cross each other, swap A[p2] with pivot (s index)element A[s],only p2 has the right to swap with pivot
        // after swapping pivot element will be at right position
        swap(A, s, p2);
        //  int temp=A[s];
        //  A[s]=A[p2];
        //  A[p2]=temp;
        return p2;
    }

    // recursive method to call quicksort on right and left of the pivot element
    public static int[] QuickSort(int[] A, int s, int e) {
        if (s < e) {
            //    Choose a pivot element from the array.
            int pivot = rearrange(A, s, e);
            // partiton created element before pivot are less than and after pivot greater element
            //    Recursively apply Quick Sort to each subarray until the entire array is sorted.
            QuickSort(A, s, pivot - 1);
            QuickSort(A, pivot + 1, e);
        }
        return A;
    }

    //method to swap the element
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] A = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        quickSort.solve2(A);
        for (int x : A
        ) {
            System.out.println(x);
        }
    }

    public int[] solve(int[] A) {
        int n = A.length;
        int s = 0;
        int e = n - 1;
        return QuickSort(A, s, e);
    }

    public void solve2(int[] A) {
        int n = A.length;
        int s = 0;
        int e = n - 1;
        quickSort(A, s, e);
    }

    // Main QuickSort function (recursive)
    void quickSort(int[] arr, int low, int high) {
        // Base case: subarray has at least 2 elements
        if (low < high) {
            // Partition array and get pivot index
            int pi = partition(arr, low, high);
            // Recursively sort left partition (elements < pivot)
            quickSort(arr, low, pi - 1);
            // Recursively sort right partition (elements > pivot)
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function: rearranges elements around pivot
    int partition(int[] arr, int low, int high) {
        // Select pivot using median-of-three and place at high index
        int pivot = medianOfThree(arr, low, high);
        // Initialize left pointer (tracks last element < pivot)
        int i = low - 1;
        // Iterate through subarray (low to high-1)
        for (int j = low; j < high; j++) {
            // If current element < pivot
            if (arr[j] < pivot) {
                // Move left pointer forward
                i++;
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }
        // Place pivot in correct position
        swap(arr, i + 1, high);
        // Return final pivot position
        return i + 1;
    }

    // Optimized pivot selection: median-of-three strategy
    int medianOfThree(int[] arr, int low, int high) {
        // Calculate middle index (avoids overflow)
        int mid = (low + high) / 2;
        // Order low, mid, high: low <= mid <= high
        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);
        // Move median (mid) to high position
        swap(arr, mid, high);
        // Return median value as pivot
        return arr[high];
    }

}
