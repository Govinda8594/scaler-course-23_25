package com.scaler.InterviewCodingQuestionPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PairSumList {

    public static List<int[]> pairSum(int[] arr, int s) {
        // Write your code here.
        List<int[]> ans = new ArrayList<>();
        List<Integer> h = new ArrayList<>();
        int[] pair = null;
        Arrays.sort(arr);
        for (int j : arr) {

            if (h.contains(s - j)) {
                int c = Collections.frequency(h, s - j);
                pair = new int[2];
                pair[0] = s - j;
                pair[1] = j;
                while (c-- > 0)
                    ans.add(0, pair);
            }
            h.add(j);
        }
        return ans;
    }

}

