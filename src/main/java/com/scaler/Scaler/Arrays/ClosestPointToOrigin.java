package com.scaler.Scaler.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ClosestPointToOrigin {

    //Method 2:

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        // sorts the list based on euclidean distance from origin
        Collections.sort(A, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                long d1 = (long) a.get(0) * a.get(0) + (long) a.get(1) * a.get(1);
                long d2 = (long) b.get(0) * b.get(0) + (long) b.get(1) * b.get(1);
                if (d1 < d2) {
                    return -1;
                } else if (d1 > d2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < B; i++) {
            ans.add(A.get(i));
        }
        return ans;
    }
}
