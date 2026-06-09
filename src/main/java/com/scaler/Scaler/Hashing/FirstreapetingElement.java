package com.scaler.Scaler.Hashing;

import java.util.HashMap;
import java.util.HashSet;

//Given an integer array A of size N, find the first repeating element in it.
//        We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
//        If there is no repeating element, return -1.

public class FirstreapetingElement {
    public int solve(int[] A) {
        int len = A.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<len;i++){
            set.add(A[i]);
        }
        return set.size();
    }

    public int solve1(int[] A) {
        int len = A.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<len;i++){
            if(map.containsKey(A[i])){
                int val = map.get(A[i]);
                map.put(A[i],val + 1);
            }else map.put(A[i],1);
        }

        for(int i =0;i<len;i++){
            if(map.get(A[i]) > 1)
                return A[i];
        }
        return -1;
    }

    public int solve2(int[] A) {
        int rtrn = -1;
        HashMap<Integer,Integer> hMapA = new HashMap<Integer,Integer>();
        for(int i=A.length-1;i>=0;i--){
            if(hMapA.containsKey(A[i]))
                rtrn = A[i];
            else
                hMapA.put(A[i],i);
        }
        return rtrn;
    }
}
