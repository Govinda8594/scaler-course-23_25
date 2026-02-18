package com.scaler.Scaler.Sorting;

import java.util.Arrays;

public record TimSort<T extends Comparable<T>>(T[] arr) {

    private static final int MIN_RUN_SIZE = 4;

    public static void main(String[] args) {

        Integer[] integers = {10, 55, -5, 34, 7, 22, 19, 27, -87, 12, 9, 41, -67, -32, 92, 17, 23, 45, -22, 29};
        String[] strings = {"Tyrion", "Arya", "Daenerys", "Sansa", "Cersei"};
        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));

        new TimSort<>(integers).sort();
        new TimSort<>(strings).sort();
        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));

    }

    public void sort() {
        // Sort each run with Insertion Sort
        for (int start = 0; start < arr.length; start += MIN_RUN_SIZE) {
            int end = Math.min((start + MIN_RUN_SIZE - 1), (arr.length - 1));
            new InsertionSort_Tim<>(arr).sort(start, end);
        }

        // Merge the sorted runs with the help of MergeSort
        for (int runSize = MIN_RUN_SIZE; runSize < arr.length; runSize *= 2) {
            for (int left = 0; left < arr.length; left += 2 * runSize) {
                int mid = left + runSize - 1;
                int right = Math.min((left + 2 * runSize - 1), (arr.length - 1));
                if (mid < right) new MergeSort_Tim<>(arr).merge(left, mid, right);
            }
        }
    }


}

record InsertionSort_Tim<T extends Comparable<T>>(T[] arr) {

    public void sort(int start, int end) {
        for (int i = start; i <= end; i++) {
            int j = i;
            // for descending order switch < operator to > operator
            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                T temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }
}


record MergeSort_Tim<T extends Comparable<T>>(T[] arr) {

    public void sort() {
        mergesort(0, arr.length - 1);
    }

    private void mergesort(int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        mergesort(low, middle);
        mergesort(middle + 1, high);
        merge(low, middle, high);
    }

    void merge(int low, int middle, int high) {

        T[] leftArray = (T[]) new Comparable[middle - low + 1];
        T[] rightArray = (T[]) new Comparable[high - middle];

        System.arraycopy(arr, low, leftArray, 0, leftArray.length);
        System.arraycopy(arr, middle + 1, rightArray, 0, rightArray.length);

        int leftSubArrCounter = 0;
        int rightSubArrCounter = 0;
        int arrCounter = low;
        while (leftSubArrCounter < leftArray.length && rightSubArrCounter < rightArray.length) {
            arr[arrCounter++] = leftArray[leftSubArrCounter].compareTo(rightArray[rightSubArrCounter]) <= 0
                    // for descending order switch < operator to > operator
                    ? leftArray[leftSubArrCounter++]
                    : rightArray[rightSubArrCounter++];
        }

        while (leftSubArrCounter < leftArray.length) {
            arr[arrCounter++] = leftArray[leftSubArrCounter++];
        }

        while (rightSubArrCounter < rightArray.length) {
            arr[arrCounter++] = rightArray[rightSubArrCounter++];
        }

    }
}