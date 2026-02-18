package com.scaler.Scaler.Sorting;

import java.util.ArrayList;
import java.util.List;

public class ClassicBucketSort {

    ClassicBucketSort() {

    }

    void sort(float[] arr) {
        if (arr.length == 0) return;
        // 1. Create empty buckets (extra space)
        List<Float>[] buckets = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();  // Auxiliary space
        }

        // 2. Distribute elements (not in-place)
        for (float num : arr) {
            int bucketIdx = (int) (num * 10);//for float point
            buckets[bucketIdx].add(num);
        }

        // 3. Sort buckets (requires additional space)
        for (List<Float> bucket : buckets) {
//            Collections.sort(bucket);  // Creates temporary arrays
            // sort with using insertion sort
            insertionSort(bucket);
        }

        // 4. Concatenate buckets (overwrites original)
        int idx = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[idx++] = num;
            }
        }
    }


    public void insertionSort(List<Float> arr) {
        for (int i = 1; i < arr.size(); i++) {
            Float key = arr.get(i);
            int j = i;
            // Shift elements > key to the right
            while (j >= 0 && arr.get(j - 1) > key) {
                arr.set(j, arr.get(j-1));
//                arr[j] = arr[j-1];
                j--;
            }
            arr.set(j, key);
//            arr[j] = key; // Insert key
        }
    }

}
