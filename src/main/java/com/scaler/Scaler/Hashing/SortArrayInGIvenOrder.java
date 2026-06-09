package com.scaler.Scaler.Hashing;

import java.util.HashMap;
import java.util.TreeMap;
//Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
//        For the elements not present in B, append them at last in sorted order.
//        Return the array A after sorting from the above method.
//        NOTE: Elements of B are unique.
//A = [1, 2, 3, 4, 5, 4]
//        B = [5, 4, 2]
//   ans =      [5, 4, 4, 2, 1, 3]
public class SortArrayInGIvenOrder {
    public int[] solve(int[] A, int[] B) {
          HashMap<Integer, Integer> hm = new HashMap<>();
         for(int i : A){
             hm.put(i, hm.getOrDefault(i,0)+1);
         }
         int[] ans = new int[A.length];
         int index = 0;
         TreeMap<Integer, Integer> tm = new TreeMap<>(hm);
         for(int i : B){
             if(tm.containsKey(i)){
                 for(int j = 0; j < tm.get(i); j++){
                     ans[index++] = i;
                 }
                 tm.remove(i);
             }
         }
         for (int i : tm.keySet()) {
            int freq = tm.get(i);
            for (int j = 0; j < freq; j++) {
                ans[index++] = i;
            }
        }
        return ans;
    }
}
