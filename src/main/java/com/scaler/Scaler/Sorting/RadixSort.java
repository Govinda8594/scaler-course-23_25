package com.scaler.Scaler.Sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RadixSort {

    private final int[] arr;

    public RadixSort(int[] arr) {
        this.arr = arr;
    }

    void sort() {
        Map<Boolean, List<Integer>> splitArray = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i < 0));
        int[] negativeInts = radixSort(splitArray.get(true).stream().mapToInt(Integer::intValue).map(Math::abs).toArray());
        int[] positiveInts = radixSort(splitArray.get(false).stream().mapToInt(Integer::intValue).toArray());

        for (int i = negativeInts.length - 1, j = 0; i >= 0; i--, j++) {
            arr[j] = -negativeInts[i];
        }
        System.arraycopy(positiveInts, 0, arr, negativeInts.length, positiveInts.length);
    }

    // For array of string sorting go from MSB to LSB
    // for array of integer sorting go from LSB to MSB
    public int[] radixSort(int[] arr) {
        // Find maximum number to determine digit count
        int max = Arrays.stream(arr).max().getAsInt();

        // Perform counting sort for each digit (LSB to MSB)
        // pos is position of digit in number,ie 1s,10s,100s => unit,ten,hunders  etc
        for (int pos = 1; max / pos > 0; pos *= 10) {
            countingSortByDigit(arr, pos);
        }
        return arr;
    }

    private void countingSortByDigit(int[] arr, int pos) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];  // Digits 0-9

        // Count occurrences of each digit
        for (int num : arr) {
            int digit = (num / pos) % 10;   // digit at places
            count[digit]++;
        }

        // take pre-fix usm
        // Cumulative count (determine positions)
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array (reverse order for stability)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / pos) % 10;
            output[count[digit] - 1] = arr[i]; // decrease the count digit value by 1 and assign the number
            count[digit]--;
        }

        // Copy output to original array
        System.arraycopy(output, 0, arr, 0, n);
    }
//    /*
//     * Returns the value of the bit at index 'bit' in 'number'
//     */
//    private static int bitValue(int number, int bit) {
//        int mask = 1 << bit;
//        if ((number & mask) != 0) {
//            return 1;
//        }
//        return 0;
//    }
//
//    /*
//     * Arrange the items in theArray based on the value of
//     * a specific bit. This doesn't fully sort the array (it
//     * just sorts by a specific bit), but we'll use it for radix
//     * sort.
//     */
//    private static int[] countingSort(int[] theArray, int bit) {
//
//        // counts[0] stores the number of items with a 0 in this bit
//        // counts[1] stores the number of items with a 1 in this bit
//        int[] counts = new int[]{0, 0};
//        for (int item : theArray) {
//            counts[bitValue(item, bit)] += 1;
//        }
//
//        // indices[0] stores the index where we should put the next item
//        // with a 0 in this bit.
//        // indices[1] stores the index where we should put the next item
//        // with a 1 in this bit.
//        //
//        // the items with a 0 in this bit come at the beginning (index 0).
//        // the items with a 1 in this bit come after all the items with a 0.
//        int[] indices = new int[]{0, counts[0]};
//
//        // output array to be filled in
//        int[] sortedArray = new int[theArray.length];
//
//        for (int item : theArray) {
//
//            int itemBitValue = bitValue(item, bit);
//
//            // place the item at the next open index for its bit value
//            sortedArray[indices[itemBitValue]] = item;
//
//            // the next item with the same bit value goes after this item
//            indices[itemBitValue] += 1;
//        }
//
//        return sortedArray;
//    }
//
//    /*
//     * Use counting sort to arrange the numbers, from least significant
//     * bit to most significant bit.
//     */
//    public static int[] radixSort2(int[] theArray) {
//
//        for (int bitIndex = 0; bitIndex < 64; bitIndex++) {
//            theArray = countingSort(theArray, bitIndex);
//        }
//        return theArray;
//    }
//
//    /////////////////////////////////////////////////////////////////////////////////////////////////////////

}
