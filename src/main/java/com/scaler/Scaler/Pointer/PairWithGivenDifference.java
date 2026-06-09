package com.scaler.Scaler.Pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

//Given an one-dimensional integer array A of size N and an integer B.
//        Count all distinct pairs with difference equal to B.
//        Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.
public class PairWithGivenDifference {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        // sort the array
        int N = A.length;
        int p1 = 0, p2 = 1, count = 0;
        while (p2 < N) {
            if (p1 > 0 && A[p1] == A[p1 - 1] && A[p2] == A[p2 - 1]) {
                // this condition is for test cases like [1,1,1,1,1,1] , [1,1,2, 2, 2] to avoid ArrayIndexOutofBound and extra count value
                p1++;
                p2++;
                continue;
            }
            int val = A[p2] - A[p1];
            if (val == B) {
                count++;
                p1++;
                p2++;
            } else if (val < B) {
                p2++;
            } else {
                p1++;
                if (p1 == p2) {
                    p2++;
                }
            }
        }
        return count;
    }
    ///////////////////////////////////////////////////////////////////////////

    public int solve2(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int i = 0, j = 1;
        long ans = 0;
        while (j < A.size()) {
            if (j == i) {
                j++;
                continue;
            }
            int x = A.get(i), y = A.get(j);
            if (y - x == B) {
                // count the pair A[i], A[j] only once
                ans++;
                while (i < A.size() && A.get(i) == x) {
                    i++;
                }
                while (j < A.size() && A.get(j) == y) {
                    j++;
                }
            } else if (y - x > B) {
                i++;
            } else {
                j++;
            }
        }
        return (int) ans;
    }
    //////////////////////////////////////////////////////////////////////////////////////////

    public int solve3(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;
        int i = 0, j = 1;
        int diff = Integer.MIN_VALUE;
// Use HashMap to store unique pairs & discard repeated pairs
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (i < n && j < n) {
            diff = A[j] - A[i];
            if (diff < B) {
                j++;
            } else if (diff > B) {
                i++;
            } else if (diff == B) {
                if (i != j) {
                    hm.put(A[i], A[j]);
                }
                i++;
            }
        }
        return hm.size();
    }
}
