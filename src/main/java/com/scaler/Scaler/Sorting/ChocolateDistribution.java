package com.scaler.Scaler.Sorting;

import java.util.Arrays;
//Given an array A of N integers where the i-th element represent the number of chocolates in the i-th packet.
//        There are B number of students, the task is to distribute chocolate packets following below conditions:
//        1. Each student gets one packets.
//        2. The difference between the number of chocolates given to any two students is minimum.
//        Return the minimum difference (that can be achieved) between the student who gets minimum number of chocolates and the student who gets maximum number of chocolates.
public class ChocolateDistribution {
        public int solve(int[] A, int B) {
            Arrays.sort(A);
            int start = 0,last = B-1,min = Integer.MAX_VALUE,len = A.length;
            if(B ==0 || len == 0) return 0;
            // sliding window of b-1 students
            while(last < len){
                min = Math.min(min,A[last] - A[start]);
                start++;
                last++;
            }
            return min;
        }
}
