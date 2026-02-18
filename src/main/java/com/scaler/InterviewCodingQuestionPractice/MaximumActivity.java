package com.scaler.InterviewCodingQuestionPractice;

import java.util.*;

public class MaximumActivity {
    public static void main(String[] args) {
//        maximumActivities();
    }
        public static int maximumActivities(java.util.List<Integer> start, java.util.List<Integer> end) {
            //Write your code here
            ArrayList<Integer> ans = new ArrayList<>();
            int len = start.size();
            int[][] map = new int[len][3];
            for(int i = 0;i<len;i++){
                map[i][0] = i + 1;
                map[i][1] = (int)start.get(i);
                map[i][2] = (int)end.get(i);
            }

            Arrays.sort(map, Comparator.comparingInt(o ->o[2]));
            int r = map[0][2];
            ans.add(map[0][0]);

            for(int i = 0;i<len;i++){
                if(map[i][1] >= r){
                    ans.add(map[i][0]);
                    r = map[i][2];
                }
            }
            return ans.size();
        }
}
