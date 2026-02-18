package com.scaler.Scaler.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
//Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.
//        The same repeated number may be chosen from A unlimited number of times.
//        Note:
//        1) All numbers (including target) will be positive integers.
//        2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//        3) The combinations themselves must be sorted in ascending order.
//        4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
//        5) The solution set must not contain duplicate combinations.
//        Problem Constraints
//        1 <= |A| <= 20
//        1 <= A[i] <= 50
//        1 <= B <= 500

public class CombinationSum {

    static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> A, int B) {
        // add your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(A);
        solve(0, A, B, A.size(), res, new ArrayList<Integer>());
        return res;
    }

    static void solve(int i, ArrayList<Integer> A, int sum, int n, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ans) {
        if (i == n - 1) {
            res.add(ans);
        }
        if (sum <= 0)
            return;
        ans.add(A.get(i));
        for (int j = i; j < n; j++) {
            solve(j, A, sum - A.get(i), n, res, ans);
        }
        ans.remove(ans.size() - 1);
    }
    ////////////////////////////////////////////////Duplicate no in array but chose same no any no of time/////////////////////////////////////////////////////////////////////

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A == null) {
            return ans;
        }
        A = new ArrayList<>(A.stream().distinct().collect(Collectors.toList()));
//        for (int i = 1; i < A.size(); i++) {
//            if (A.get(i - 1) == A.get(i))
//                A.remove(A.get(i - 1));
//        }
        Collections.sort(A);
        combinationSum(A, new ArrayList<>(), B, 0, ans);
        return ans;
    }

    public void combinationSum(ArrayList<Integer> A, ArrayList<Integer> res, int B, int index, ArrayList<ArrayList<Integer>> ans) {
        if (B == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }
        if (B < 0) {
            return;
        }
        // try for all possible next candidate
        for (int i = index; i < A.size(); i++) {
            int num = A.get(i);
            res.add(num);
            combinationSum(A, res, B - num, i, ans);  //Note i is not incrementes, the same repeated number may be chosen from A unlimited number of times.
            res.remove(res.size() - 1);
        }
    }

}
