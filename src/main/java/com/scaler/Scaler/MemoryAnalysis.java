package com.scaler.Scaler;

public class MemoryAnalysis {
    public static void analyzeMemoryUsage(int[] arr, String algorithmName) {
        Runtime runtime = Runtime.getRuntime();

        // Run garbage collection
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // Run the sorting algorithm
        switch (algorithmName) {
//            case "Bubble" -> BubbleSort.bubbleSort(arr.clone());
//            case "Quick" -> QuickSort.quickSort(arr.clone());
//            case "Heap" -> HeapSort.heapSort(arr.clone());
        }

        runtime.gc();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

        long memoryUsed = memoryAfter - memoryBefore;
        System.out.printf("%-15s: %10d bytes\n", algorithmName, memoryUsed);
    }
}