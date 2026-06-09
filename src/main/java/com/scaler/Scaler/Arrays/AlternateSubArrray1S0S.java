package com.scaler.Scaler.Arrays;

import java.util.ArrayList;

public class AlternateSubArrray1S0S {

    public static void main(String[] args) {
        int[] A = new int[]{0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1};
//        int B = 1;
//        int subArraySize = 2 * B + 1;
//        ArrayList<Integer> ans = new ArrayList<Integer>();
//        for (int i = 0; i < A.length; i++) {
//            int flag = 1;
//            int limit = i + subArraySize - 1;
//            for (int j = i; j + 1 <= limit; j++) {
//                if (A[j] == A[j + 1]) {
//                    flag = 0;
//                    break;
//                }
//            }
//            if (flag == 1) {
//                ans.add(i + B);
//            }
//        }
////        3 7 8
//        System.out.println(ans.toString());
        AlternateSubArrray1S0S.alternateSubarray(A, 3);
    }

    public static int[] AlternateSubArrray1S0S(int[] A, int B) {
        int subArraySize = 2 * B + 1;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int i = 0, j = subArraySize - 1;
        while (j < A.length) {
            int flag = checkAltenrateOccurence(A, i, j);
            if (flag == 1) {
                temp.add(i + B);
            }
            j++;
            i++;
        }
        int[] ans = new int[temp.size()];
        int k = 0;
        for (Integer index : temp) {
            ans[k++] = index;
        }
        return ans;
    }

    static int checkAltenrateOccurence(int[] A, int start, int end) {
        while (start < end) {
            if (A[start] == A[start + 1]) return 0;
            start++;
        }
        return 1;
    }

    // sliding window approch
    static int[] alternate(int[] A, int B) {
        int len = A.length;
        int windowSize = 2 * B + 1;
        int current_window_size = 1;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if (B == 0) temp.add(0);
        for (int i = 1; i < len; i++) {
            if (A[i - 1] == A[i]) {
                current_window_size = 1;
            } else current_window_size++;
            if (current_window_size >= windowSize) {
                temp.add(i - B);
            }

        }
        int[] ans = new int[temp.size()];
        int k = 0;
        for (Integer index : temp) {
            ans[k++] = index;
        }
        return ans;
    }

    static ArrayList<Integer> alternateSubarray(int[] A, int B) {
        int len = A.length;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = B; i < len - B; i++) {
            boolean isValid = true;

            for (int j = i - B; j < i + B; j++) {
                if (A[j] == A[j + 1]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                ans.add(i);
            }
        }

        return ans;
    }

}
