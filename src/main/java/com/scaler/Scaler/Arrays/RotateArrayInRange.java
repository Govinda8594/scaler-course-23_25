package com.scaler.Scaler.Arrays;

import java.util.ArrayList;

public class RotateArrayInRange {

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        int range = B % len;
        reverse(A, 0, len - range);
        reverse(A, len - range, len);
        reverse(A, 0, len);
        return A;
    }

    public static ArrayList<Integer> reverse(ArrayList<Integer> A, int B, int C) {
        C--;
        while (B < C) {
            int temp = A.get(B);
            A.set(B++, A.get(C));
            A.set(C--, temp);
        }
        return A;
    }

    public static ArrayList<Integer> reverseArray(ArrayList<Integer> A, int B, int C) {
        while (B < C) {
            int temp = A.get(B);
            A.set(B++, A.get(C));
            A.set(C--, temp);
        }
        return A;
    }
}
