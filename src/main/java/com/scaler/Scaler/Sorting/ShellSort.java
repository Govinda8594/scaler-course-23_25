package com.scaler.Scaler.Sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

// Extend Generic Comparable for string and integer both
public record ShellSort<T extends Comparable<T>>(T[] arr) {

    static void main(String[] args) {

        Integer[] integers = {10, 55, -5, 34, 7, 22, 19};
        String[] strings = {"Tyrion", "Arya", "Daenerys", "Sansa", "Cersei"};
        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        new ShellSort<>(integers).sort();
        new ShellSort<>(strings).sortRecursively();

        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));

    }

    public static void shellSort2(int[] arr) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public void sort() {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j >= gap && arr[j].compareTo(arr[j - gap]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                    j -= gap;
                }
            }
        }
    }

    public void sortRecursively() {
        IntStream.iterate(arr.length / 2, gap -> gap > 0, gap -> gap / 2).forEach(gap ->
                IntStream.range(gap, arr.length).forEach(index -> sort(index, gap))
        );
    }

    private void sort(int index, int gap) {
        if (index >= gap && arr[index].compareTo(arr[index - gap]) < 0) {
            T temp = arr[index];
            arr[index] = arr[index - 1];
            arr[index - 1] = temp;
            sort(index - gap, gap);
        }
    }

    // Optimized Shell Sort (Knuth Sequence + Shifting)
//    Better theoretical complexity (O(n<sup>1.5</sup>) vs O(n²)
//            2-5x faster execution in practice
//    More efficient memory operations
    public void shellSort(int[] arr) {
        int n = arr.length;

        // Generate Knuth sequence (1, 4, 13, 40, ...)
        int gap = 1;
        while (gap < n / 3) {
            gap = 3 * gap + 1;
        }

        // Iterate with decreasing gaps
        while (gap > 0) {
            // Perform gapped insertion sort
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                // Shift elements with gap-sized steps
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
// Next smaller Knuth number
            gap /= 3;
        }
    }
}
