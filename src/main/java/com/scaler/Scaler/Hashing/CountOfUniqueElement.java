package com.scaler.Scaler.Hashing;

//You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.

import java.util.HashMap;
import java.util.HashSet;

public class CountOfUniqueElement {
    public int solve(int[] A) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : A) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        for (int j : A) {
            if (map.get(j) == 1) {
                count++;
            }
        }
        return count;
    }

    //////////////////////////////////////////////////////////////
    public int solve2(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : A) {
            set.add(j);
        }
        return set.size();
    }
}

