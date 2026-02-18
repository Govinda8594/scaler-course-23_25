package com.scaler.InterviewCodingQuestionPractice;

public class CountInversion {
    public static void main(String[] args) {
        System.out.println(getInversions(new long[]{5, 8, 6, 3, 4, 6}, 6));
    }

    public static long getInversions(long arr[], int n) {
        // Write your code here.
        long count = 0;
        int i = 0, j = i + 1;
        while (i < n && j < n) {
            if (i < j && arr[i] > arr[j]) {
                count++;
            }
            j++;
            if (j == n) {
                i++;
                j = i + 1;
            }
        }
        return count;
    }
}
