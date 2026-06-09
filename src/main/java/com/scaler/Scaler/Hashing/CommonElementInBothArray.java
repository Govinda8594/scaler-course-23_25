package com.scaler.Scaler.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonElementInBothArray {
    public int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> li = new ArrayList<>();
        for (int j : A) {
            hm.put(j, hm.getOrDefault(j, 0) + 1);
        }
        for (int j : B) {
            if (hm.containsKey(j)) {
                if (hm.get(j) > 0) {
                    li.add(j);
                    hm.put(j, hm.get(j) - 1);
                }
            }
        }
        return li.stream().mapToInt(Integer::intValue).toArray();

//        int[] arr = new int[li.size()];
//        for (int i = 0; i < arr.length; i++)
//            arr[i] = li.get(i);
//        return arr;
    }
}
