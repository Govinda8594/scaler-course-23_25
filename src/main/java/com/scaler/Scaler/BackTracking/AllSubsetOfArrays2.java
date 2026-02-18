package com.scaler.Scaler.BackTracking;

import java.util.ArrayList;
import java.util.Collections;

//Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.
//
//        NOTE:
//
//        Elements in a subset must be in non-descending order.
//        The solution set must not contain duplicate subsets.
//        The subsets must be sorted lexicographically.

public class AllSubsetOfArrays2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        res.add(temp);
        Collections.sort(A);
        rec(A, res, temp, 0);
        return res;
    }

    public void rec(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int idx) {
        if (idx == A.size()) {
            return;
        }
        temp.add(A.get(idx));
        res.add(new ArrayList<>(temp));
        rec(A, res, temp, idx + 1);
        temp.remove(temp.size() - 1);
        //check duplicate elements
        while (idx + 1 < A.size() && A.get(idx) == A.get(idx + 1)) {
            idx++;
        }
        rec(A, res, temp, idx + 1);
    }


}
