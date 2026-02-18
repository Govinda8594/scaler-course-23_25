package com.scaler.Scaler.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;


//Given an integer array A of size N denoting collection of numbers , return all possible permutations.
//
//        NOTE:
//
//        No two entries in the permutation sequence should be the same.
//        For the purpose of this problem, assume that all the numbers in the collection are unique.
//        Return the answer in any order

public class ReturnAllPermutationOfArray {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.addAll(Arrays.asList(1, 2, 3));
        ReturnAllPermutationOfArray permutation = new ReturnAllPermutationOfArray();
        permutation.permute(a);
    }


    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        // Create answer ArrayList
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        // Go through all permutation starting from 0
        permuteAll(A, 0, ans);
        return ans;
    }

    private void permuteAll(ArrayList<Integer> A, int i, ArrayList<ArrayList<Integer>> ans) {
        // If my current index is at end insert copy of current permuted ArrayList
        if (i == A.size()) {
            ans.add(new ArrayList<Integer>(A));
        }
        for (int j = i; j < A.size(); ++j) {
            // Swap each index
            swap(i, j, A);
            // Go through all permutation starting from next index
            permuteAll(A, i + 1, ans);
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
