package com.scaler.Scaler.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
//Given a set of distinct integers A, return all possible subsets.
//        NOTE:
//        Elements in a subset must be in non-descending order.
//        The solution set must not contain duplicate subsets.
//        Also, the subsets should be sorted in ascending ( lexicographic ) order.
//        The initial list is not necessarily sorted.

public class AllSubsetOfArrays {

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.addAll(Arrays.asList(1, 2, 3));
        subsets(a);
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A); //sort because we need smaller ele first
        ArrayList<Integer> curr = new ArrayList<>();
        ans.add(curr); //as per the expected o/p case when not selecting any element
        addList(curr, 0, A);   //calling our recursive function to do the dirty work
        return ans;
    }

    public static void addList(ArrayList<Integer> curr, int i, ArrayList<Integer> A) {
        if (i == A.size()) //this means we have exhausted our options for current arraylist
        {
            return;     // therefore simply return.
        }
        curr.add(A.get(i));  // case when we select our current element
        ans.add(new ArrayList<>(curr));  // adding copy of list in ANSWERlist with curr selected element
        // NOTE: we have added a copy of our current arraylist which will not reflect any changes
        // to our current arraylist made by further recursive calls (this is important to understand)
        addList(curr, i + 1, A);
        curr.remove(curr.size() - 1); //case when we did not select current element
        //NOTE: addition of arraylist (one without having curr element) to our final ANSWERlist,
        // will be taken care by the next recursive call below, so we need not add it explicitly otherwise we will just be adding empty lists
        addList(curr, i + 1, A);
    }

    ///////////////////////////////////////////more optimised/////////////////////////////////////////////
    public static ArrayList<ArrayList<Integer>> subsets2(ArrayList<Integer> A) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        subsets(A, 0, new ArrayList<>(), result);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int size = Math.min(o1.size(), o2.size());
                for (int i = 0; i < size; i++) {
                    int comp = o1.get(i) - o2.get(i);
                    if (comp != 0) {
                        return comp;
                    }
                }
                return o1.size() - o2.size();
            }
        });
        return result;
    }

    private static void subsets(ArrayList<Integer> list, int index, ArrayList<Integer> current,
                                ArrayList<ArrayList<Integer>> result) {
        if (index == list.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        subsets(list, index + 1, current, result);
        current.add(list.get(index));
        subsets(list, index + 1, current, result);
        current.remove(current.size() - 1);
    }

}
