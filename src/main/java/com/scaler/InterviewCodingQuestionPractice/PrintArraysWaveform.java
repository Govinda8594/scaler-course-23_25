package com.scaler.InterviewCodingQuestionPractice;

public class PrintArraysWaveform {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 4, 6, 8, 9};
        waveform(a, 6);
        System.out.println(a);
    }

    static void waveform(int[] array, int n) {
        for (int i = 0; i < n - 1; i += 2) {
            int temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
    }
}
