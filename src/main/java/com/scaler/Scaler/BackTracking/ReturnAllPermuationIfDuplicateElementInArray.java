package com.scaler.Scaler.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
//Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
//
//        NOTE: No 2 entries in the permutation sequence should be the same.

public class ReturnAllPermuationIfDuplicateElementInArray {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        // Create answer ArrayList
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        // Go through all permutation starting from 0
        permuteAll(A, 0, ans, hs);
        return ans;
    }

    private void permuteAll(ArrayList<Integer> A, int i, ArrayList<ArrayList<Integer>> ans, HashSet<ArrayList<Integer>> hs) {
        // If my current index is at end and not added before insert copy of current permuted ArrayList
        if (i == A.size() && hs.add(A)) {
            ans.add(new ArrayList<Integer>(A));
        }
        for (int j = i; j < A.size(); ++j) {
            // Swap each index
            swap(i, j, A);
            // Go through all permutation starting from next index
            permuteAll(A, i + 1, ans, hs);
            // Swap back to original index
            swap(j, i, A);
        }
    }

    private void swap(int i, int j, ArrayList<Integer> A) {
        // If source and destination is same then there is no point of swapping
        if (i == j) {
            return;
        }
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
