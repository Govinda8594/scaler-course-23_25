package com.scaler.Scaler.DynamicProgramming;
//Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
//        Also given an integer C which represents knapsack capacity.
//        Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).
//        NOTE:
//        You can break an item for maximizing the total value of the knapsack

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    /////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
//        A = [60, 100, 120]
//        B = [10, 20, 30]
//        C = 50
        int[] A = new int[]{60, 100, 120};
        int[] B = new int[]{10, 20, 30};
        solve(A, B, 50);
    }

    public static int solve(int[] A, int[] B, int C) {
        int n = A.length;
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = A[i];
            items[i][1] = B[i];
        }
//        a[0]/a[1] > b[0]/b[1]
//        Which implies a[0] * b[1] > b[0] * a[1]
        Arrays.sort(items, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                long product1 = (long) b[0] * a[1];
                long product2 = (long) a[0] * b[1];
                return Long.compare(product1, product2);
            }
        });

        int totalCents = 0;
        int capLeft = C;

        for (int i = 0; i < n && capLeft > 0; i++) {
            int value = items[i][0];
            int weight = items[i][1];
            if (weight <= capLeft) {
                totalCents += value * 100;
                capLeft -= weight;
            } else {
                long amount = (long) value * capLeft * 100;
                totalCents += (int) (amount / weight);
                capLeft = 0;
            }
        }

        return totalCents;
    }

    public int solve2(int[] A, int[] B, int C) {
        int N = A.length;
        KnapsackItem[] items = new KnapsackItem[N];
        // Create KnapsackItems based on input arrays A and B
        for (int i = 0; i < N; i++) {
            items[i] = new KnapsackItem(B[i], 100 * A[i] * 1.0 / B[i]);
        }
        // Sort items array in descending order based on valuePerWeight using a lambda expression
        Arrays.sort(items, (a, b) -> Double.compare(b.valuePerWeight, a.valuePerWeight));
        double value = 0;
        // Iterate through the sorted items array and add items to the knapsack until capacity C is reached
        for (int i = 0; i < N && C > 0; i++) {
            int min = Math.min(items[i].weight, C);
            value += items[i].valuePerWeight * min;
            C = C - min;
        }
        // Return the maximum value that can be achieved
        return (int) Math.floor(value);
    }

    class KnapsackItem {
        int weight;
        double valuePerWeight;

        public KnapsackItem(int weight, double valuePerWeight) {
            this.weight = weight;
            this.valuePerWeight = valuePerWeight;
        }
    }
}
