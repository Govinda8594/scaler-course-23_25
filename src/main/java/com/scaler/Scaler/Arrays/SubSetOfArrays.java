package com.scaler.Scaler.Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class SubSetOfArrays {
        public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            Collections.sort(A);
            ArrayList<Integer> emptyset = new ArrayList<Integer>();
            ans.add(emptyset);
            int len = A.size();
            for(int i = 0;i<len;i++){
                for(int j = i;j<len;j++){
                    ArrayList<Integer> set = new ArrayList<Integer>();
                    for(int k = i;k<=j;k++){
                        set.add(A.get(k));
                    }
                    ans.add(set);
                }
            }
            return ans;
        }

}
