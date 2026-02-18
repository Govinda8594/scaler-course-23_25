package com.scaler.Scaler.Heap;

import java.util.*;

public class Two_SortedArray_FindK_Smallest_Pair {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 11};
        int[] arr2 = {2, 4, 8};
        int k = 4;
        List<Integer> result = kSmallestPair(arr1, arr2, k);
        System.out.println(result);
    }

    public static List<Integer> kSmallestPair2(int[] arr1, int[] arr2, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(new int[]{arr1[i] + arr2[j], i, j});
                } else {
                    int[] curr = maxHeap.peek();
                    if (arr1[i] + arr2[j] < curr[0]) {
                        maxHeap.poll();
                        maxHeap.offer(new int[]{arr1[i] + arr2[j], i, j});
                    }
                }
            }
        }
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            result.add(0, curr[0]);
        }
        return result;
    }

    //////////////////////////////////////////////////////////////////////////////////
//k log k
    public static List<int[]> kSmallestPair3(int[] arr1, int[] arr2, int k) {
        // Edge case: Return empty list for invalid inputs
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0 || k <= 0) {
            return new ArrayList<>();
        }

        int n1 = arr1.length; // Length of first array
        int n2 = arr2.length; // Length of second array
        List<int[]> result = new ArrayList<>(); // Stores the k smallest pairs

        // Min-heap to prioritize pairs [i, j] by the sum (arr1[i] + arr2[j])
        // Comparator: (a, b) -> (arr1[a[0]] + arr2[a[1]]) - (arr1[b[0]] + arr2[b[1]])
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
                (arr1[a[0]] + arr2[a[1]]) - (arr1[b[0]] + arr2[b[1]]));

        // Tracks visited index pairs (i, j) to avoid duplicates
        // Key = i * n2 + j (encoded as long to prevent overflow)
        Set<Long> visited = new HashSet<>();

        // Start with the smallest possible pair: indices (0, 0)
        minHeap.offer(new int[]{0, 0});
        visited.add(0L); // Mark (0, 0) as visited

        // Process until we have k pairs or the heap is empty
        while (k > 0 && !minHeap.isEmpty()) {
            // Get the pair with the smallest sum
            int[] curr = minHeap.poll();
            int i = curr[0]; // Index in arr1
            int j = curr[1]; // Index in arr2

            // Add the actual elements to the result
            result.add(new int[]{arr1[i], arr2[j]});
            k--; // Decrement remaining pairs to find

            // Explore next candidate: (i+1, j) if within bounds
            if (i + 1 < n1) {
                long key = (long) (i + 1) * n2 + j; // Encode indices to a unique key
                if (!visited.contains(key)) {
                    visited.add(key); // Mark as visited
                    minHeap.offer(new int[]{i + 1, j}); // Add to heap
                }
            }

            // Explore next candidate: (i, j+1) if within bounds
            if (j + 1 < n2) {
                long key = (long) i * n2 + (j + 1); // Encode indices to a unique key
                if (!visited.contains(key)) {
                    visited.add(key); // Mark as visited
                    minHeap.offer(new int[]{i, j + 1}); // Add to heap
                }
            }
        }

        return result;
    }
    //////////////////////////////////////////////////////////////////////////////////////

    public static List<Integer> kSmallestPair(int[] arr1, int[] arr2, int k) {
        List<Integer> result = new ArrayList<>();
        for (int value : arr1) {
            for (int i : arr2) {
                result.add(value + i);
            }
        }
        Collections.sort(result);
        return result.subList(0, k);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    public static List<int[]> kSmallestPairs(int[] a, int[] b, int k) {
        List<int[]> result = new ArrayList<>();
        if (a.length == 0 || b.length == 0 || k <= 0) return result;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(p -> a[p.i] + b[p.j])
        );
        Set<Pair> visited = new HashSet<>();

        Pair start = new Pair(0, 0);
        minHeap.offer(start);
        visited.add(start);

        while (!minHeap.isEmpty() && result.size() < k) {
            Pair curr = minHeap.poll();
            result.add(new int[]{a[curr.i], b[curr.j]});

            // Push (i+1, j)
            if (curr.i + 1 < a.length) {
                Pair nextI = new Pair(curr.i + 1, curr.j);
                if (!visited.contains(nextI)) {
                    minHeap.offer(nextI);
                    visited.add(nextI);
                }
            }

            // Push (i, j+1)
            if (curr.j + 1 < b.length) {
                Pair nextJ = new Pair(curr.i, curr.j + 1);
                if (!visited.contains(nextJ)) {
                    minHeap.offer(nextJ);
                    visited.add(nextJ);
                }
            }
        }

        return result;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    static class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return i == p.i && j == p.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
