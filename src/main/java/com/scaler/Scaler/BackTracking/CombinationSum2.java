package com.scaler.Scaler.BackTracking;

import java.util.ArrayList;
import java.util.Collections;


//Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.
//        Each number in A may only be used once in the combination.
//        Note:
//        All numbers (including target) will be positive integers.
//        Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//        The solution set must not contain duplicate combinations.
//        Warning:
//        DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
//        Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.
//        Problem Constraints
//        1 <= N <= 20
public class CombinationSum2 {

    public ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Collections.sort(A);
        findCombinations(ans, A, B, 0, temp);
        return ans;
    }

    public void findCombinations(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> A, int sum, int index, ArrayList<Integer> temp) {
        if (sum == 0) {
            if (!ans.contains(temp)) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if (sum < 0) {
            return;
        }
        for (int i = index; i < A.size(); i++) {
            temp.add(A.get(i));
            findCombinations(ans, A, sum - A.get(i), i + 1, temp); // Note i is incremented, Each number in A may only be used once in the combination.
            temp.remove(temp.size() - 1);
        }
    }

    
}
