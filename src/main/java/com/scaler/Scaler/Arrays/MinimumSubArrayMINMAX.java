package com.scaler.Scaler.Arrays;

import java.util.ArrayList;

public class MinimumSubArrayMINMAX {
    public static void main(String[] args) {
//        MinimumSubArrayMINMAX(args);

    }
        public static int MinimumSubArrayMINMAX(ArrayList<Integer> A) {
            int max_val = A.get(0);
            int min_val = A.get(0);
            int min_idx = -1;
            int max_idx = -1;
            for (Integer a : A) {
                max_val = Math.max(max_val, a);
                min_val = Math.min(min_val, a);
            }
            int len = A.size();
            if (max_val == min_val) return 1;
            for (int i = len - 1; i >= 0; i--) {
                if (A.get(i) == max_val) {
                    max_idx = i;
                    if (min_idx != -1)
                        len = Math.min(len, min_idx - max_idx + 1);
                } else if (A.get(i) == min_val) {
                    min_idx = i;
                    if (max_idx != -1) {
                        len = Math.min(len, max_idx - min_idx + 1);
                    }
                }
            }
            return len;
        }

}
